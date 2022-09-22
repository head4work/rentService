package com.masterpiece.rentService.controller.rent;

import com.masterpiece.rentService.model.AjaxResponseBody;
import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.model.Rent;
import com.masterpiece.rentService.model.RentData;
import com.masterpiece.rentService.repository.datajpa.CrudLotRepository;
import com.masterpiece.rentService.service.RentService;
import com.masterpiece.rentService.util.RentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RentRestController {


    private RentService rentService;

    @Autowired
    private CrudLotRepository lotRepository;

    public RentRestController(RentService rentService) {
        this.rentService = rentService;
    }


    @PostMapping("/rent")
    public ResponseEntity<?> rentLot(@RequestBody RentData data, Errors errors) {
        AjaxResponseBody result = new AjaxResponseBody();

        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);
        }

        Lot lot = lotRepository.getReferenceById(data.getLotId());
        Rent rent = new Rent(data.getStartRentDate(), data.getEndRentDate(), lot);
        rentService.create(rent);
        result.setMsg("success");
        result.setDisableDates(RentUtil.getRangeDates(data.getStartRentDate(), data.getEndRentDate()));
        return ResponseEntity.ok(result);
    }

}
