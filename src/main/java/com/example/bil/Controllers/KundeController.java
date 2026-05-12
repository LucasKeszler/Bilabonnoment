package com.example.bil.Controllers;

import com.example.bil.Models.Kunde;
import com.example.bil.Services.KundeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KundeController {

    private KundeService kundeService;

    public KundeController(KundeService kundeService) {
        this.kundeService = kundeService;
    }

    @GetMapping("/kunde/create")
    public ModelAndView showCreateKundePage() {
        return new ModelAndView("create-kunde");
    }

    @PostMapping("/kunde/create")
    public ModelAndView createKunde(@RequestParam String navn,
                                    @RequestParam String email,
                                    @RequestParam String telefon) {

        Kunde kunde = new Kunde(navn, email, telefon);

        kundeService.createKunde(kunde);

        return new ModelAndView("redirect:/kunde/create?success=true");
    }
}