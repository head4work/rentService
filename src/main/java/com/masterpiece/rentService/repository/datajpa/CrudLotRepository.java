package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudLotRepository extends JpaRepository<Lot, Integer> {
}
