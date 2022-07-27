package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudRentRepository extends JpaRepository<Rent, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Rent r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT r FROM Rent r WHERE r.user.id=:userId ORDER BY r.endRentDate DESC")
    List<Rent> getAll(@Param("userId") int userId);

}
