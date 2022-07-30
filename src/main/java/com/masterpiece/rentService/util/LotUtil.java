package com.masterpiece.rentService.util;

import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.model.to.LotTo;

import java.time.LocalDateTime;
import java.util.List;

public class LotUtil {
    public static List<Lot> getALlWithDatesReduced(List<Lot> lots) {
        lots.forEach(lot -> lot.getRents().removeIf(rent -> rent.getEndRentDate().compareTo(LocalDateTime.now()) < 0));
        return lots;
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
