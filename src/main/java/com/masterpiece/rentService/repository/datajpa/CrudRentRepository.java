package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudRentRepository extends JpaRepository<Rent,Integer> {

}
