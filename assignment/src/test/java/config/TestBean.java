package config;

import com.uxpsystems.assignment.dao.Status;
import com.uxpsystems.assignment.dao.User;
import org.springframework.context.annotation.Bean;

public class TestBean {

    @Bean("testUser")
    public User createUser(){
        User testUser = new User((long) 3, "test", "test", Status.Activated);
        return testUser;
    }
}
