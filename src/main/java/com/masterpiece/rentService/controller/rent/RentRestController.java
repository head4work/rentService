package com.masterpiece.rentService.controller.rent;

import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.model.Rent;
import com.masterpiece.rentService.model.RentData;
import com.masterpiece.rentService.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/api")
public class RentRestController {
    @Autowired
    private EntityManager entityManager;

    private RentService rentService;

    public RentRestController(RentService rentService) {
        this.rentService = rentService;
    }


    @PostMapping("/rent")
    public ResponseEntity<Rent> rentLot(@RequestBody RentData data) {
        Lot lot = entityManager.getReference(Lot.class, data.getLotId());
        Rent rent = new Rent(data.getStartRentDate(), data.getEndRentDate(), lot);
        rentService.create(rent);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rent);
    }

}
