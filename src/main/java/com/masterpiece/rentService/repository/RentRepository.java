package com.masterpiece.rentService.repository;

import com.masterpiece.rentService.model.Rent;

import java.time.LocalDateTime;
import java.util.List;

public interface RentRepository {
    // null if updated meal do not belong to userId
    Rent save(Rent meal, int userId);

    // false if meal do not belong to userId
    boolean delete(int id, int userId);

    // null if meal do not belong to userId
    Rent get(int id, int userId);

    // ORDERED dateTime desc
    List<Rent> getAll(int userId);

    // ORDERED dateTime desc
    List<Rent> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId);

    default Rent getWithUser(int id, int userId) {
        throw new UnsupportedOperationException();
    }

}
