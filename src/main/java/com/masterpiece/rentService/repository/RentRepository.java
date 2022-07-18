package com.masterpiece.rentService.repository;

import com.masterpiece.rentService.model.Rent;

public interface RentRepository {
    // null if updated lot do not belong to userId
    Rent save(Rent rent, int userId);

    // false if lot do not rented by userId
    boolean delete(int id, int userId);

    // sorted by date
    Rent getAll(int userId);

   /* default Rent getWithUser(int id, int userId) {
        throw new UnsupportedOperationException();
    }*/

}
