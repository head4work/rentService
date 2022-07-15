package com.masterpiece.rentService.repository;

import com.masterpiece.rentService.model.Lot;

import java.util.List;

public interface LotRepository {

    Lot save(Lot lot, int userID);

    boolean delete(int id, int userId);

    Lot get(int id);

    List<Lot> getAll();

}
