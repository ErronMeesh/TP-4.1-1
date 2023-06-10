package backend.controller;

import backend.model.Spain;
import backend.model.HistoryOfOrders;
import backend.model.User;
import backend.service.SpainService;
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
public class SpainController {
    // все необходимые сервисы
    @Autowired
    private UserService userService;
    @Autowired
    private SpainService spainService;
    @Autowired
    private HistoryOfOrdersService historyOfOrdersService;

    // маппинг для конретного метода с указанием типа (get/post)
    // в итоге метод сработает при get запросе пользователя на страницу /plane/add
    @GetMapping("/Spain")
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

        List<Spain> destP = spainService.getAll();

        model.addAttribute("destP", destP);


        return "ready-html/spain.html";
    }

    @PostMapping("/Spain")
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
            List<Spain> flights = spainService.getByDestinationP(selectorName);
//            model.addAttribute("flights", flights);
            Spain flight = flights.get(0);
            historyOfOrdersService.add(new HistoryOfOrders(user, flight.getPriceOfBc(), flight.getDepartureTime(), flight.getDepartureP(), flight.getDestinationP(), flight.getFlightId()));
        }
        return "redirect:/Form";
    }


}
