package com.irisi.etaxeSecurity.ws.pub;


import com.irisi.etaxeSecurity.bean.User;
import com.irisi.etaxeSecurity.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class UserController {
	@Autowired private UserService userService;

    @PostMapping("/login")
    public String logIn(@RequestBody User user) {
    	System.out.println(user.getUsername());
        return userService.logIn(user);
    }

    
}
