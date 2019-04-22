package config;

import com.uxpsystems.assignment.controller.UserController;
import org.springframework.context.annotation.Bean;

public class MyWebConfig {
    @Bean
    public UserController userController () {
        return new UserController();
    }
}
