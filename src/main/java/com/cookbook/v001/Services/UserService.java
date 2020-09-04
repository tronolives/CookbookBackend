package com.cookbook.v001.Services;

import com.cookbook.v001.Entities.User;
import com.cookbook.v001.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean userExists(String username) {
        User requestedUser = userRepository.findByUsername(username);
        return requestedUser == null;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

}
