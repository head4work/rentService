package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.Rent;
import com.masterpiece.rentService.repository.RentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaRentRepository implements RentRepository {

    private CrudRentRepository crudRentRepository;

    public DataJpaRentRepository(CrudRentRepository crudRentRepository) {
        this.crudRentRepository = crudRentRepository;
    }

    @Override
    public Rent save(Rent meal, int userId) {
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public Rent get(int id, int userId) {
        return null;
    }

    @Override
    public List<Rent> getAll(int userId) {
        return null;
    }


}
