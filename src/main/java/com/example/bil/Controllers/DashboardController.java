package com.example.bil.Controllers;

import com.example.bil.Services.DashboardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    private DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard")
    public ModelAndView showDashboard() {
        ModelAndView mav = new ModelAndView("dashboard");

        mav.addObject("antalUdlejede", dashboardService.getAntalUdlejedeBiler());
        mav.addObject("samletPris", dashboardService.getSamletPrisAktiveLejeaftaler());
        mav.addObject("indtjeningMaaned", dashboardService.getIndtjeningDenneMaaned());
        mav.addObject("antalTilbageleverede", dashboardService.getAntalTilbageleveredeBiler());
        mav.addObject("bilerMedSkader", dashboardService.getBilerMedSkader());

        return mav;
    }
}