package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.Rent;
import com.masterpiece.rentService.repository.RentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaRentRepository implements RentRepository {

    private CrudRentRepository crudRentRepository;
    private CrudUserRepository crudUserRepository;

    public DataJpaRentRepository(CrudRentRepository crudRentRepository, CrudUserRepository crudUserRepository) {
        this.crudRentRepository = crudRentRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Override
    public Rent save(Rent rent, int userId) {
        if (!rent.isNew() && get(rent.id(), userId) == null) {
            return null;
        }
        rent.setUser(crudUserRepository.findById(userId).orElse(null));
        return crudRentRepository.save(rent);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudRentRepository.delete(id, userId) != 0;
    }

    @Override
    public Rent get(int id, int userId) {
        return crudRentRepository.findById(id).filter(rent -> rent.getUser().id() == userId).orElse(null);
    }

    @Override
    public List<Rent> getAll(int userId) {
        return crudRentRepository.findAll();
    }


}
