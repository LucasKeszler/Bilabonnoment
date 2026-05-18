package com.example.bil.Controllers;

import com.example.bil.Models.Car;
import com.example.bil.Models.CarStatus;
import com.example.bil.Services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/biler")
    public ModelAndView showBiler() {
        ModelAndView mav = new ModelAndView("biler");
        mav.addObject("biler", carService.getAllCars());
        return mav;
    }

    @GetMapping("/biler/opret")
    public ModelAndView showCreateBilForm() {
        return new ModelAndView("opret-bil");
    }

    @PostMapping("/biler/opret")
    public String createBil(@RequestParam String vognummer,
                            @RequestParam String stelnummer,
                            @RequestParam String maerke,
                            @RequestParam String model,
                            @RequestParam String nummerplade,
                            @RequestParam String lokation,
                            @RequestParam double maanedspris) {

        Car car = new Car(
                vognummer,
                stelnummer,
                maerke,
                model,
                nummerplade,
                CarStatus.LEDIG,
                lokation,
                maanedspris
        );

        carService.createCar(car);

        return "redirect:/biler";
    }
}