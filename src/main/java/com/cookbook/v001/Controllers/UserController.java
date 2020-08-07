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

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name,
                                           @RequestParam String email){
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

}
