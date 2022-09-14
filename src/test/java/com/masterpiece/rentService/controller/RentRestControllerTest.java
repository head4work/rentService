package com.masterpiece.rentService.controller;

import com.masterpiece.rentService.controller.rent.RentRestController;
import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.model.Rent;
import com.masterpiece.rentService.repository.LotRepository;
import com.masterpiece.rentService.repository.RentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class RentRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RentRestController controller;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private LotRepository lotRepository;

    @Test
    public void createRent() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime start = LocalDateTime.parse("2022-09-02T07:00:00.000Z", formatter);
        LocalDateTime end = LocalDateTime.parse("2022-09-04T07:00:00.000Z", formatter);
        Lot lot = lotRepository.get(100003);
        Rent newRent = new Rent(start, end, lot);
        ResponseEntity<Rent> rentResponse = controller.rentLot(newRent);
        assertThat(rentResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
