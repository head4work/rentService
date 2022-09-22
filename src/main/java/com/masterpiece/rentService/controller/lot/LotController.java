package com.masterpiece.rentService.controller.lot;

import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.service.LotService;
import com.masterpiece.rentService.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Controller
@RequestMapping("/lots")
public class LotController {

    @Autowired
    private RentService rentService;

    private LotService lotService;


    public LotController(LotService lotService) {
        this.lotService = lotService;
    }

    @GetMapping
    public String listLots(Model model) {
        model.addAttribute("lots", lotService.getAll());
        return "lots";
    }

    @GetMapping("/delete/{id}")
    public String deleteLot(@PathVariable int id) {
        lotService.delete(id);
        return "redirect:/lots";
    }

    @GetMapping("/new")
    public String createLot(Model model) {
        model.addAttribute("lot", new Lot(LocalDateTime.now().truncatedTo(ChronoUnit.HOURS)));
        return "lotForm";
    }

    @GetMapping("/edit/{id}")
    public String lotUpdate(@PathVariable int id, Model model) {
        model.addAttribute("lot", lotService.get(id));
        return "lotForm";
    }

    @PostMapping("/new")
    public String createLot(@Valid Lot lot, BindingResult result) {
        if (result.hasErrors()) {
            return "lotForm";
        }
        lotService.create(lot);
        return "redirect:/lots";
    }

    @GetMapping("/rent/{id}")
    public String rentLot(@PathVariable int id, Model model) {
        Lot lot = lotService.get(id);
        model.addAttribute("lot", lot);
        model.addAttribute("lotRentDates", rentService.getLotRentDates(lot));
        return "rentForm";
    }

}
