package com.example.restfulapp.security;

import com.example.restfulapp.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
// TODO: Version 3.1.0 de commentteki gib fakat çalışmadi o yzden projeyi 2.5.5 e aldim

/*
//Bu class ile auth u yönetiyoruz galiba WebSecurityConfigurerAdapter bu da security starterdan geliyor
@EnableWebSecurity
public class WebSecurity {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public WebSecurity(UserService userService,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Bean //Springin protected SecurityFilterChain triggerlaması için bean yapildi
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authManager = http.getSharedObject(AuthenticationManagerBuilder.class);

        authManager.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
        // amk methodu çalismadi 401 verip duruyor

        AuthenticationManager authenticationManager = authManager.build();
        http.authenticationManager(authenticationManager);
        // Spring 3.1 versiyon kulllanimi
        http.authorizeHttpRequests(auth ->
                auth.requestMatchers(new AntPathRequestMatcher("/users/create", "POST"))
                .permitAll()
                .anyRequest()
                .authenticated());

        return http.build();
    }
}
*/
// TODO: Version 2.5.5 te WebSecurityConfigurerAdapter deplere degil
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public WebSecurity(UserService userService,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //BU method ile neleri public yapıcagimizi belirtiyor
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users/create")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }
}