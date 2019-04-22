package com.uxpsystems.assignment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan()
public class ApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }

//    @Bean
//    CommandLineRunner initDatabase(UserRepository repository) {
//        return args -> {
//            repository.save(new User(1, "admin", "admin", Status.Activated));
//        };
//    }

}
