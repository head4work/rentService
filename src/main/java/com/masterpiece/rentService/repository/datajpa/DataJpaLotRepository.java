package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.repository.LotRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaLotRepository implements LotRepository {

    private final CrudLotRepository lotRepository;

    public DataJpaLotRepository(CrudLotRepository lotRepository) {
        this.lotRepository = lotRepository;
    }

    @Override
    public Lot save(Lot lot, int userID) {
        return lotRepository.save(lot);
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public Lot get(int id) {
        return null;
    }

    @Override
    public List<Lot> getAll() {
        return null;
    }
}
