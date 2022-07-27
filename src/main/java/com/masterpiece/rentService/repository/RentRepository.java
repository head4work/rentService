package com.masterpiece.rentService.repository;

import com.masterpiece.rentService.model.Rent;

import java.util.List;

public interface RentRepository {
    // null if updated lot do not belong to userId
    Rent save(Rent rent, int userId);

    // admin only
    boolean delete(int id);

    //return null if it doesn't belong to user or adminId
    Rent get(int id, int userId);

    // sorted by date
    List<Rent> getAll(int userId);

   /* default Rent getWithUser(int id, int userId) {
        throw new UnsupportedOperationException();
    }*/

}
