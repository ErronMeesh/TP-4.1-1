package backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //тут надо прописать путь до страницы входа в логин юзера
        registry.addViewController("/log").setViewName("ready-html/loginp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/cssp/**").addResourceLocations("classpath:/static/cssp/");
        registry.addResourceHandler("/cssform/**").addResourceLocations("classpath:/static/cssform/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static/fonts/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/jsp/**").addResourceLocations("classpath:/static/jsp/");
        registry.addResourceHandler("/gsap/**").addResourceLocations("classpath:/static/gsap/");
        registry.addResourceHandler("/media/**").addResourceLocations("classpath:/static/media/");
    }
}