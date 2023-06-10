package backend.controller;

import backend.model.HistoryOfOrders;
import backend.model.User;
import backend.service.HistoryOfOrdersService;
import backend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api (tags = "User Controller")
// общий маппинг для всех контроллеров внутри этого класса
@RequestMapping("")
public class UserController {
    // все необходимые сервисы
    @Autowired
    private UserService userService;
    @Autowired
    private HistoryOfOrdersService historyOfOrdersService;

    // маппинг для конретного метода с указанием типа (get/post)
    // в итоге метод сработает при get запросе пользователя на страницу /plane/add
    @GetMapping("/reg")
    @ApiOperation("Get registration page")

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

        // тут какая-то логика необходимая этой странице
        /*
            ...
         */
        // путь до html файла внутри папки frontend
        return "ready-html/regip";
    }

    @PostMapping("/reg")
    @ApiOperation("Handle registration form submission")
    // @RequestParam указывается у всех параметров, которые должны считываться на странице фронта
    // и передаваться на серв, при этом имена переменных должны 1в1 совпадать с тем как они названы на фронте
    public String testAddControllerMethod_POSTMAPPING(Principal principal, Model model, @RequestParam String login,
                                                      @RequestParam String password) {
        // проверяем авторизован ли пользователь
        boolean authorized = principal != null;
        // добавляем на фронт параметр authorized
        model.addAttribute("authorized", authorized);
        if (authorized) {
            // можно получить информацию о текущем пользователе
            User user = userService.getByLogin(principal.getName());
            model.addAttribute("user", user);
        }
        // тут какая-то логика необходимая этой странице
        // создаём нового пользователя
        boolean added = userService.add(new User(login, password, login, Boolean.FALSE));
        // проверяем добавился он или нет (например такой логин уже был занят)
        if (!added) {
            model.addAttribute("error", "ошибка регистрации");
            return "ready-html/regip";
        }
        // при успешной регистрации делаем переадресацию на страницу входа
        // после redirect указывается url нужной страницы
        return "redirect:/log";
    }
}
