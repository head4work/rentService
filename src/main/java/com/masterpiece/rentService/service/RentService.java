package com.masterpiece.rentService.service;

import com.masterpiece.rentService.model.Rent;
import com.masterpiece.rentService.repository.RentRepository;
import com.masterpiece.rentService.util.SecurityUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
}
