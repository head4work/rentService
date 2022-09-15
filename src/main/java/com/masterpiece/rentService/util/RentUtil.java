package com.masterpiece.rentService.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class RentUtil {
    public Set<LocalDate> getRangeDates(LocalDateTime start, LocalDateTime end) {
        return start.toLocalDate().datesUntil(end.toLocalDate())
                .collect(Collectors.toSet());
    }
}
