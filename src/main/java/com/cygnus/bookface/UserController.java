package com.cygnus.bookface;

import java.util.List;

// import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.util.Pair;

@RestController
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users/register")
    public Pair<String, UserClass> registerUser(@RequestBody UserClass user) {
        List<UserClass> allusers = userRepository.findAll();
        for (UserClass u: allusers) {
            if (u.equals(user)) {
                return Pair.of("User already exists", user);
            }
        }
        userRepository.save(user);
        return Pair.of("User succesfully created", user);
    }

    @GetMapping("/users/register")
    public List<UserClass> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users/login")
    public Pair<String, UserClass> loginUser(@RequestBody UserClass user) {
        List<UserClass> allusers = userRepository.findAll();

        for(UserClass u : allusers) {
            if (u.equals(user)) {
                UserClass newUserLoggedIn = new UserClass(user, u.getID());
                newUserLoggedIn.setLoggedin(true);
                userRepository.save(newUserLoggedIn);
                return Pair.of("User logged in", newUserLoggedIn);
            }

        }
        return Pair.of("User does not exist", user);
    }

    @PostMapping("/users/logout")
    public Pair<String, UserClass> logoutUser(@RequestBody UserClass user) {
        List<UserClass> allusers = userRepository.findAll();

        for(UserClass u : allusers) {
            if (u.equals(user)) {
                UserClass newUserLoggedOut = new UserClass(user, u.getID());
                newUserLoggedOut.setLoggedin(false);
                userRepository.save(newUserLoggedOut);
                return Pair.of("User logged out", newUserLoggedOut);
            }

        }
        return Pair.of("User does not exist", user);
    }
}