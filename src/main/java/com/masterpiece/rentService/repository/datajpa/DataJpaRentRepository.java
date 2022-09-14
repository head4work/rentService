package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.exception.NotFoundException;
import com.masterpiece.rentService.model.Rent;
import com.masterpiece.rentService.model.User;
import com.masterpiece.rentService.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DataJpaRentRepository implements RentRepository {

    @Autowired
    EntityManager entityManager;

    private CrudRentRepository crudRentRepository;

    public DataJpaRentRepository(CrudRentRepository crudRentRepository) {
        this.crudRentRepository = crudRentRepository;
    }

    @Override
    public Rent save(Rent rent, int userId) {
        if (!rent.isNew() && get(rent.id(), userId) == null) {
            return null;
        }
        User user = entityManager.getReference(User.class, userId);
        //  rent.setUser(crudUserRepository.findById(userId).orElse(null));
        if (user != null) {
            rent.setUser(user);
        } else {
            throw new NotFoundException(" user with id:" + userId + " not found");
        }
        return crudRentRepository.save(rent);
    }

    @Override
    public boolean delete(int id) {
        return crudRentRepository.delete(id) != 0;
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
