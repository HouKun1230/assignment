package com.uxpsystems.assignment.controller;

import com.uxpsystems.assignment.dao.User;
import com.uxpsystems.assignment.exception.ResourcesNotFoundException;
import com.uxpsystems.assignment.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    //  id (long) / primary key
    //  username (String) / unique
    //  password
    // status / possible values: Activated/Deactivated

    //Get
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUsers(@PathVariable("id") Long id) {
        log.debug("getUser Method IN");
        User user = userService.findUser(id);
        log.debug(user.toString());
        if(user == null){
            throw new ResourcesNotFoundException("User not found!");
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }


    // Create
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity signupUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity("Insert successfully", HttpStatus.OK);
    }


    // Save or update
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody User user, @PathVariable Long id) {
        userService.updateUser(user, id);
        return new ResponseEntity("Update successfully", HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBook(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity("Delete successfully", HttpStatus.OK);

    }




}
