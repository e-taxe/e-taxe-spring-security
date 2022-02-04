package com.irisi.etaxeSecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.CommandLineRunner;

import com.irisi.etaxeSecurity.bean.Role;
import com.irisi.etaxeSecurity.bean.User;
import com.irisi.etaxeSecurity.service.facade.UserService;

import java.util.Arrays;




@SpringBootApplication
@ComponentScan({ "com.irisi.etaxeSecurity.service.facade.UserService",
	"com.irisi.etaxeSecurity.service","com.irisi.etaxeSecurity.config"
	, "com.irisi.etaxeSecurity.filter"})
public class ETaxeSpringSecurityApplication implements CommandLineRunner{

	
	
    
    
	public static void main(String[] args) {
		SpringApplication.run(ETaxeSpringSecurityApplication.class, args);
	}


	@Autowired
    private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		if(true){
            User admin = new User("admax","admax");
            admin.setAuthorities(Arrays.asList(new Role("ROLE_ADMIN")));
            userService.save(admin);
        }
		
	}

}
