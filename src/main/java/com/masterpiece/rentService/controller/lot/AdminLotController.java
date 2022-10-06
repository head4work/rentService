package com.masterpiece.rentService.controller.lot;

import com.masterpiece.rentService.model.Lot;
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
@RequestMapping("/admin/lots")
public class AdminLotController extends AbstractLotController {

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("lots", super.getAll());
        return "adminLots";
    }

    @GetMapping("/delete/{id}")
    public String deleteLot(@PathVariable int id) {
        super.delete(id);
        return "redirect:/admin/lots";
    }

    @GetMapping("/new")
    public String createLot(Model model) {
        model.addAttribute("lot", new Lot(LocalDateTime.now().truncatedTo(ChronoUnit.HOURS)));
        return "lotForm";
    }

    @GetMapping("/edit/{id}")
    public String lotUpdate(@PathVariable int id, Model model) {
        model.addAttribute("lot", super.get(id));
        return "lotForm";
    }

    @PostMapping("/new")
    public String createLot(@Valid Lot lot, BindingResult result) {
        if (result.hasErrors()) {
            return "lotForm";
        }
        super.create(lot);
        return "redirect:/admin/lots";
    }

    @GetMapping("/rent/{id}")
    public String rentLot(@PathVariable int id, Model model) {
        Lot lot = super.get(id);
        model.addAttribute("lot", lot);
        model.addAttribute("lotRentDates", super.getLotRentDates(lot));
        return "rentForm";
    }

}
