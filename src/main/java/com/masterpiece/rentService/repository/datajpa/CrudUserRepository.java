package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudUserRepository extends JpaRepository<User,Integer> {

}
