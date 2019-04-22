package com.uxpsystems.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {



    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

    // Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/users/**").hasRole("USER")
//                .antMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/users/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PATCH, "/users/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
//                .anyRequest()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .headers()
                .frameOptions().disable()
                .and()
                .csrf().disable()
                .formLogin().disable();
    }


}
