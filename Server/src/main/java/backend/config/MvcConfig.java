package backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //тут надо прописать путь до страницы входа в логин юзера
        //слева url как на сайте будет (начинается со слеша)
        //справа путь до html файла в папке templates (начинается сразу с имени папки)
        registry.addViewController("/user/log").setViewName("test_dir_1/test_html_1");
    }
}