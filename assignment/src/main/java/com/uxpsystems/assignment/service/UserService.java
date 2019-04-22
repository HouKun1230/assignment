package com.uxpsystems.assignment.service;

import com.uxpsystems.assignment.dao.User;
import com.uxpsystems.assignment.exception.ResourcesNotFoundException;
import com.uxpsystems.assignment.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    public User findUser(Long id){
        return userRepository.findById(id).orElseThrow(
                () -> new ResourcesNotFoundException("User not found with userId " + id.toString()));

    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user, Long id){
        userRepository.findById(id)
                .map(x -> {
                    x.setId(user.getId());
                    x.setPassword(user.getPassword());
                    x.setUsername(user.getUsername());
                    return userRepository.save(x);
                })
                .orElseGet(() -> {
                    user.setId(id);
                    return userRepository.save(user);
                });
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
