package com.irisi.etaxeSecurity.ws.admin;


import com.irisi.etaxeSecurity.bean.User;
import com.irisi.etaxeSecurity.service.facade.UserService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private UserService userService;
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/login")
    public String logIn(@RequestBody User user) {
        return userService.logIn(user);
    }


    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }


    @GetMapping("/username/{username}")
    public UserDetails loadUserByUsername(@PathVariable String username) throws UsernameNotFoundException {
        return userService.loadUserByUsername(username);
    }


}
