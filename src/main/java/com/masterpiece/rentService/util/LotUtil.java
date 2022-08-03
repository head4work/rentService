package com.masterpiece.rentService.util;

import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.model.Rent;
import com.masterpiece.rentService.model.to.LotTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LotUtil {
    public static List<Lot> getALlWithDatesReduced(List<Lot> lots) {
        lots.forEach(lot -> lot.getRents().removeIf(rent -> rent.getEndRentDate().compareTo(LocalDateTime.now()) < 0));
        return lots;
    }

    public static Rent saveRent(LocalDateTime start, LocalDateTime end, int lotId, int userId) {
        Map<LocalDate, Integer> map = new ConcurrentHashMap<>();
        return null;
    }

    public static List<LotTo> lotTos(List<Lot> lots) {
    /*    lots.stream().map((Function<Lot, LotTo>) lot -> {
            Boolean available = lot.getRents().stream()
                    .filter(rent -> rent.getEndRentDate().compareTo(LocalDateTime.now()) < 0)
                    .collect(Collectors.toList()).isEmpty();


        })*/
        return null;
    }

    public static LotTo createTo(Lot lot, boolean available) {
        return new LotTo(lot.id(), lot.getName(), lot.getDescription(), lot.getPrice(), lot.getImage(), available);
    }
}
