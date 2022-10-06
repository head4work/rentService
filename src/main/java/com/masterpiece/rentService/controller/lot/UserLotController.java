package com.masterpiece.rentService.controller.lot;

import com.masterpiece.rentService.model.Lot;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lots")
public class UserLotController extends AbstractLotController {

    @GetMapping
    public String listLots(Model model) {
        model.addAttribute("lots", super.getAll());
        return "lots";
    }

    @GetMapping("/rent/{id}")
    public String rentLot(@PathVariable int id, Model model) {
        Lot lot = super.get(id);
        model.addAttribute("lot", lot);
        model.addAttribute("lotRentDates", super.getLotRentDates(lot));
        return "rentForm";
    }
}
