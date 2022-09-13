package com.masterpiece.rentService.controller.rent;

import com.masterpiece.rentService.model.Rent;
import com.masterpiece.rentService.service.RentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class RentRestController {
    private RentService rentService;

    public RentRestController(RentService rentService) {
        this.rentService = rentService;
    }


    @PostMapping("/rent")
    public ResponseEntity<String> rentLot(@RequestBody Rent rent) {
        rentService.create(rent);
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

}
