package com.masterpiece.rentService.repository.datajpa;

import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.service.LotService;
import com.masterpiece.rentService.service.RentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;

@SpringBootTest
class DataJpaLotRepositoryTest {

    private final static Lot LOT = new Lot(100003, "post", "post for flag", BigDecimal.valueOf(10.00),
            LocalDateTime.now(), "jpg", new HashSet<>());

    @Autowired
    LotService lotService;

    @Autowired
    private RentService rentService;

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void get() {

        rentService.getLotRentDates(lotService.get(100003));
        Assertions.assertThat(lotService.get(100003)).isEqualTo(LOT);
    }

    @Test
    void getAll() {
    }
}