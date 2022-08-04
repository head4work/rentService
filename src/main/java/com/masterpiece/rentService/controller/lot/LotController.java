package com.masterpiece.rentService.controller.lot;

import com.masterpiece.rentService.service.LotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
