package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.service.LotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;

@SpringBootTest
class DataJpaLotRepositoryTest {

    @Autowired
    LotService lotService;

    @Test
    void save() {
        Lot lot = new Lot(100003, "post", "post for flag", BigDecimal.valueOf(10.00),
                LocalDateTime.now(), "jpg", new HashSet<>());
        lotService.create(lot);
    }

    @Test
    void delete() {
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }
}