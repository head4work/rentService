package com.masterpiece.rentService.controller.lot;

import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.service.LotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Controller
@RequestMapping("/lots")
public class LotController {


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

    @PostMapping("/new")
    public String createLot(@ModelAttribute("lot") Lot lot) {
        lotService.create(lot);
        return "redirect:/lots";
    }
}
