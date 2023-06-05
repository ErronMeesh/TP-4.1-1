package backend.controller;

import backend.model.Flight;
import backend.model.HistoryOfOrders;
import backend.model.User;
import backend.model.Passenger;
import backend.service.FlightService;
import backend.service.HistoryOfOrdersService;
import backend.service.PassengerService;
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
public class FormController {
    // все необходимые сервисы
    @Autowired
    private UserService userService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private HistoryOfOrdersService historyOfOrdersService;

    @Autowired
    private PassengerService passengerService;


    // маппинг для конретного метода с указанием типа (get/post)
    // в итоге метод сработает при get запросе пользователя на страницу /plane/add
    @GetMapping("/Form")
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
            List<HistoryOfOrders> historyList = historyOfOrdersService.getByUser(user);
            model.addAttribute("historyList", historyList);
        }
        return "ready-html/form.html";
    }


    @PostMapping("/Form")
    public String testAddControllerMethod_POSTMAPPING(Principal principal, Model model, @RequestParam String surname,
                                                      @RequestParam String name, @RequestParam String lastname, @RequestParam  String phoneNumber, @RequestParam String mail, @RequestParam String docSeries, @RequestParam String docNum) {
//        System.out.println(selectorName);
        boolean authorized = principal != null;
        // добавляем на фронт параметр authorized
        model.addAttribute("authorized", authorized);

            // можно получить информацию о текущем пользователе
            User user = userService.getByLogin(principal.getName());
            model.addAttribute("user", user);
            passengerService.add(new Passenger(surname, name, lastname,phoneNumber,mail,docSeries,docNum,user));


        return "redirect:/FormQr";
    }

}
