package com.irisi.etaxeSecurity.config;

import com.irisi.etaxeSecurity.filter.JwtAuthenticationFilter;
import com.irisi.etaxeSecurity.filter.JwtAutorisationFilter;
import com.irisi.etaxeSecurity.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private UserService userService;
    @Autowired private JwtAutorisationFilter jwtAutorisationFilter;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http
        .cors()
        .and()
        .csrf().disable()
        .authorizeRequests()
        
        .antMatchers(HttpMethod.POST, "/api/admin/login","/api/public/login").permitAll()
        .antMatchers("/api/public/**").permitAll()
        .antMatchers("/api/admin/**").hasAuthority("ROLE_ADMIN")
        .anyRequest().authenticated()
        .and()
        .headers().frameOptions().sameOrigin().and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilter(new JwtAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(jwtAutorisationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
   public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
