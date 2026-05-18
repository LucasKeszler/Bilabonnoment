package com.example.bil.Controllers;

import com.example.bil.Models.LejeAftale;
import com.example.bil.Services.CarService;
import com.example.bil.Services.KundeService;
import com.example.bil.Services.LejeaftaleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LejeAftaleController {

    private LejeaftaleService lejeaftaleService;
    private CarService carService;
    private KundeService kundeService;

    public LejeAftaleController(LejeaftaleService lejeaftaleService,
                                CarService carService,
                                KundeService kundeService) {
        this.lejeaftaleService = lejeaftaleService;
        this.carService = carService;
        this.kundeService = kundeService;
    }

    @GetMapping("/lejeaftaler")
    public ModelAndView showLejeaftaler() {
        ModelAndView mav = new ModelAndView("lejeaftaler");
        mav.addObject("lejeaftaler", lejeaftaleService.getAlleLejeaftaler());
        return mav;
    }

    @GetMapping("/lejeaftaler/opret")
    public ModelAndView showCreateLejeAftaleForm() {
        ModelAndView mav = new ModelAndView("opret-lejeaftale");
        mav.addObject("lejeAftale", new LejeAftale());
        mav.addObject("biler", carService.getAvailableCars());
        mav.addObject("kunder", kundeService.getAllKunder());
        return mav;
    }

    @PostMapping("/lejeaftaler/opret")
    public String createLejeAftale(@ModelAttribute LejeAftale lejeAftale) {
        lejeaftaleService.createLejeAftale(lejeAftale);
        return "redirect:/lejeaftaler";
    }
}