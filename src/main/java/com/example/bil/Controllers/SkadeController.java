package com.example.bil.Controllers;

import com.example.bil.Services.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SkadeController {

    private DashboardService dashboardService;

    public SkadeController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/skader")
    public ModelAndView showSkader() {
        ModelAndView mav = new ModelAndView("skader");
        mav.addObject("tilbageleveredeBiler", dashboardService.getTilbageleveredeBiler());
        return mav;
    }
}