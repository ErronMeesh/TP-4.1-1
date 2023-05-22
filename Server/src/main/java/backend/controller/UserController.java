package backend.controller;

import backend.model.User;
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

@Controller
@Api
// общий маппинг для всех контроллеров внутри этого класса
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/reg")
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

        // путь до html файла внутри папки frontend
        return "test_dir_1/test_html_2";
    }

    @PostMapping("/reg")
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

        // создаём нового пользователя
        boolean added = userService.add(new User(login, password, login, Boolean.TRUE));
        // проверяем добавился он или нет (например такой логин уже был занят)
        if (!added) {
            model.addAttribute("error", "ошибка регистрации");
            return "test_dir_1/test_html_2";
        }
        // при успешной регистрации делаем переадресацию на страницу входа
        // после redirect указывается url нужной страницы
        return "redirect:/user/log";
    }
}
