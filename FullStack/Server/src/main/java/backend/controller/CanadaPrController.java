package backend.controller;

import backend.model.Flight;
import backend.model.HistoryOfOrders;
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
// общий маппинг для всех контроллеров внутри этого класса
@RequestMapping("")
public class CanadaPrController {
    // все необходимые сервисы
    @Autowired
    private UserService userService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private HistoryOfOrdersService historyOfOrdersService;

    // маппинг для конретного метода с указанием типа (get/post)
    // в итоге метод сработает при get запросе пользователя на страницу /plane/add
    @GetMapping("/CanadaPremium")
    // Principal - взаимодействие с текущем пользователем
    // Model - взаимодействие со страницей (html)
    public String testAddControllerMethod_GETMAPPING(Principal principal, Model model) {
        // проверяем авторизован ли пользователь
        boolean authorized = principal != null;
        // добавляем на фронт параметр authorized
        model.addAttribute("authorized", authorized);
        if (authorized) {
            // можно получить информацию о текущем пользователе
            User user = userService.getByLogin(principal.getName());
            model.addAttribute("user", user);
        }
//        flightService.getAll();


//        List<Flight> destP = Flight.getDestinationP();
//        model.addAttribute("destp", destP);
//
//

        List<Flight> destP = flightService.getAll();

        model.addAttribute("destP", destP);
//
//        model.addAttribute("destP0", destP.get(0).getDestinationP());
//        model.addAttribute("destP1", destP.get(1).getDestinationP());
//        model.addAttribute("destP2", destP.get(2).getDestinationP());



//        model.addAttribute("destP3", destP.get(3).getDestinationP());
//        model.addAttribute("destP4", destP.get(4).getDestinationP());
//        model.addAttribute("destP5", destP.get(5).getDestinationP());
//        model.addAttribute("destP6", destP.get(6).getDestinationP());
//        model.addAttribute("destP7", destP.get(7).getDestinationP());
//        model.addAttribute("destP8", destP.get(8).getDestinationP());

        return "ready-html/canadaPrem.html";
    }

    @PostMapping("/CanadaPremium")
    // Principal - взаимодействие с текущем пользователем
    // Model - взаимодействие со страницей (html)
    public String testAddControllerMethod_POSTMAPPING(Principal principal, Model model, @RequestParam String selectorName) {
        // проверяем авторизован ли пользователь
        boolean authorized = principal != null;
        // добавляем на фронт параметр authorized
        model.addAttribute("authorized", authorized);
        if (authorized) {
            // можно получить информацию о текущем пользователе
            User user = userService.getByLogin(principal.getName());
            model.addAttribute("user", user);
            List<Flight> flights = flightService.getByDestinationP(selectorName);
//            model.addAttribute("flights", flights);
            Flight flight = flights.get(0);
            historyOfOrdersService.add(new HistoryOfOrders(user, flight.getPriceOfBc(), flight.getDepartureTime(), flight.getDepartureP(), flight.getDestinationP(), flight.getFlightId()));
        }
        return "redirect:/Form";
    }


}
