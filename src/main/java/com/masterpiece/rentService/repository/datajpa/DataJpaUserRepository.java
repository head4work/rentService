package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.User;
import com.masterpiece.rentService.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {

    private CrudUserRepository crudUserRepository;

    @Override
    @Transactional
    public User save(User user) {
        crudUserRepository.save(user);
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
