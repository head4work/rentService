package com.masterpiece.rentService.util;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class RentUtil {
    public static Set<LocalDateTime> getRangeDates(LocalDateTime start, LocalDateTime end) {
        return start.toLocalDate()
                .datesUntil(end.toLocalDate().plusDays(1))
                .map(localDate -> localDate.atTime(0, 0, 0))
                .collect(Collectors.toSet());
    }
}
