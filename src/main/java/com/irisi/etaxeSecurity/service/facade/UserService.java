package com.irisi.etaxeSecurity.service.facade;

import com.irisi.etaxeSecurity.bean.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    String logIn(User user);

    User save(User user);
   List<User> findAll();
}
