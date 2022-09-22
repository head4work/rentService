package com.masterpiece.rentService.service;

import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.model.Rent;
import com.masterpiece.rentService.repository.RentRepository;
import com.masterpiece.rentService.util.RentUtil;
import com.masterpiece.rentService.util.SecurityUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RentService {
    final private RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public Rent create(Rent rent) {
        Assert.notNull(rent, "rent must not be null");
        return rentRepository.save(rent, SecurityUtil.authUserId());
    }

    public Set<LocalDateTime> getLotRentDates(Lot lot) {
        return lot.getRents().stream()
                .map(rent -> RentUtil.getRangeDates(rent.getStartRentDate(), rent.getEndRentDate()))
                .flatMap((Function<Set<LocalDateTime>, Stream<LocalDateTime>>) Collection::stream)
                .collect(Collectors.toSet());
    }
}
