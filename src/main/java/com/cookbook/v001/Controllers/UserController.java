package com.cookbook.v001.Controllers;

import com.cookbook.v001.Entities.User;
import com.cookbook.v001.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository UserRepository) {
        this.userRepository = UserRepository;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

}
