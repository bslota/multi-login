package com.bslota.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by bslota on 2017-03-14.
 */
@Configuration
public class SecurityConfig {

    @Configuration
    @Order(1)
    public static class SpecialSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //@formatter:off
            http
                .antMatcher("/special/**")
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/special/login")
                    .defaultSuccessUrl("/special/home")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/special/logout")
                    .permitAll();
            //@formatter:on
        }
    }

    @Configuration
    public static class RegularSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //@formatter:off
            http
                .authorizeRequests()
                    .antMatchers("/css/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/regular/login")
                    .defaultSuccessUrl("/regular/home")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/regular/logout")
                    .permitAll();
            //@formatter:on
        }
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("password")
                .roles("USER");
    }
}
