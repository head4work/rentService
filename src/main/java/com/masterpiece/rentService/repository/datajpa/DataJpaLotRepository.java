package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.repository.LotRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaLotRepository implements LotRepository {
    private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");

    private final CrudLotRepository lotRepository;

    public DataJpaLotRepository(CrudLotRepository lotRepository) {
        this.lotRepository = lotRepository;
    }

    @Override
    public Lot save(Lot lot) {
        return lotRepository.save(lot);
    }

    @Override
    public boolean delete(int id) {
        return lotRepository.delete(id) != 0;
    }

    @Override
    public Lot get(int id) {
        return lotRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lot> getAll() {
        return lotRepository.findAll(SORT_NAME);
    }
}
