package backend.controller;

import backend.model.Flight;
import backend.model.HistoryOfOrders;
import backend.model.Passenger;
import backend.model.User;
import backend.service.FlightService;
import backend.service.HistoryOfOrdersService;
import backend.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
@Controller
@Api

@RequestMapping("")
public class FormQrController {

    @Autowired
    private UserService userService;

    @GetMapping("/FormQr")

    public String testAddControllerMethod_GETMAPPING(Principal principal, Model model) {

        boolean authorized = principal != null;

        model.addAttribute("authorized", authorized);
        if (authorized) {

            User user = userService.getByLogin(principal.getName());
            model.addAttribute("user", user);
        }


        return "ready-html/formqr.html";
    }

    @PostMapping("/FormQr")

    public String testAddControllerMethod_POSTMAPPING(Principal principal, Model model, @RequestParam String promo) {

        String prom = promo;
        String pro= "sky";

        if (prom.equals(pro)) {
            return "redirect:/FormSale";

        } else {
            return "ready-html/formqr";
        }

    }
}
