package backend.controller;

import backend.model.HistoryOfOrders;
import backend.model.User;
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
public class AccountController {
    // все необходимые сервисы
    @Autowired
    private UserService userService;

    @Autowired
    private HistoryOfOrdersService historyOfOrdersService;

    // маппинг для конретного метода с указанием типа (get/post)
    // в итоге метод сработает при get запросе пользователя на страницу /plane/add
    @GetMapping("/account")
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
            model.addAttribute("userStat", user.getUserStatus());
            List<HistoryOfOrders> historyList = historyOfOrdersService.getByUser(user);
            model.addAttribute("historyList", historyList);

        }



        // тут какая-то логика необходимая этой странице
        /*
            ...
         */
        // путь до html файла внутри папки frontend
        return "ready-html/account.html";
    }


}
