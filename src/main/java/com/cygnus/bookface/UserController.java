package com.cygnus.bookface;

import java.util.List;

// import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users/register")
    public String registerUser(@RequestBody UserClass user) {
        List<UserClass> allusers = userRepository.findAll();
        for (UserClass u: allusers) {
            if (u.equals(user)) {
                return "User already exists";
            }
        }
        userRepository.save(user);
        return "User successfully created";
    }

    @PostMapping("/users/login")
    public String loginUser(@RequestBody UserClass user) {
        List<UserClass> allusers = userRepository.findAll();

        for(UserClass u : allusers) {
            if (u.equals(user)) {
                user.setLoggedin(true);
                userRepository.save(user);
                return "User logged in";
            }
            
        }
        return "User does not exist";
    }
    
    @PostMapping("/users/logout")
    public String logoutUser(@RequestBody UserClass user) {
        List<UserClass> allusers = userRepository.findAll();

        for(UserClass u : allusers) {
            if (u.equals(user)) {
                user.setLoggedin(false);
                userRepository.save(user);
                return "User logged out";
            }
            
        }
        return "User does not exist";
    }
}
