package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CrudRentRepository extends JpaRepository<Rent, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Rent r WHERE r.id=:id AND r.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);


}
