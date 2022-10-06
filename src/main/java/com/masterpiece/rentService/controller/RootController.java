package com.masterpiece.rentService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String listLots() {
        return "redirect:/lots";
    }

}
