package com.example.bil.Controllers;

import com.example.bil.Models.Medarbejder;
import com.example.bil.Services.MedarbejderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private MedarbejderService medarbejderService;

    public LoginController(MedarbejderService medarbejderService) {
        this.medarbejderService = medarbejderService;
    }

    @GetMapping("/")
    public ModelAndView showLoginPage() {
        return new ModelAndView("login");
    }

    @PostMapping("/")
    public ModelAndView login(@RequestParam String username,
                              @RequestParam String password,
                              HttpSession session) {

        Medarbejder medarbejder = medarbejderService.login(username, password);

        if(medarbejder !=null) {
            session.setAttribute("medarbejder", medarbejder);

            switch (medarbejder.getRolle()) {
                case DATAREGISTRERING:
                    return new ModelAndView("redirect:/lejeaftaler");
                case SKADE:
                    return new ModelAndView("redirect:/skader");
                case BUSINESS:
                    return new ModelAndView("redirect:/dashboard");
                case ADMIN:
                    return new ModelAndView("redirect:/dashboard");
            }
        }

        ModelAndView mav = new ModelAndView("login");
        mav.addObject("error", "Forkert brugernavn eller adgangskode");
        return mav;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/login");
    }
}
