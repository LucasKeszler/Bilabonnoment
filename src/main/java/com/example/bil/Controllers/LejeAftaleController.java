package com.example.bil.Controllers;

import com.example.bil.Services.LejeaftaleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LejeAftaleController {

    private LejeaftaleService lejeaftaleService;

    public LejeAftaleController(LejeaftaleService lejeaftaleService) {
        this.lejeaftaleService = lejeaftaleService;
    }

    @GetMapping("/lejeaftaler")
    public ModelAndView showLejeaftaler() {
        ModelAndView mav = new ModelAndView("lejeaftaler");
        mav.addObject("lejeaftaler", lejeaftaleService.getAlleLejeaftaler());
        return mav;
    }
}