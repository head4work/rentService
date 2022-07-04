package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.User;
import com.masterpiece.rentService.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DataJpaUserRepository implements UserRepository {

    private CrudUserRepository crudUserRepository;

    @Override
    @Transactional
    public User save(User user) {
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
