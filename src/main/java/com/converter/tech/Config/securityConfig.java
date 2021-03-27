package com.converter.tech.Config;

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
public class securityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin().defaultSuccessUrl("/a", true);
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails thisUser = User.withDefaultPasswordEncoder().username("user")
                .password("123").roles("USER").build();


        return new InMemoryUserDetailsManager(thisUser);
    }
}
