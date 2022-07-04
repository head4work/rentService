package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRentRepository extends JpaRepository<Rent,Integer> {
}
