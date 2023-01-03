package com.example.chapter07.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecutiryConfig
{
//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private BoardUserDetailsService boardUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/member/**").authenticated()
                .antMatchers("/manager/**").hasRole("MANAGER")
                .antMatchers("/admin/**").hasRole("ADMIN");
        http.formLogin().loginPage("/login").defaultSuccessUrl("/loginSuccess", true);
        http.exceptionHandling().accessDeniedPage("/accessDenied");
        http.logout().invalidateHttpSession(true)
                        .deleteCookies()
                        .logoutSuccessUrl("/login");
        http.userDetailsService(boardUserDetailsService);
        return http.build();
    }

//    @Autowired
//    public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("manager")
//                .password("{noop}manager123")
//                .roles("MANAGER");
//
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}admin123")
//                .roles("ADMIN");
//
//        String query1 = "select id username, concat('{noop}', password) password, true enabled from member where id=?";
//        String query2 = "select id, role from member where id=?";
//
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(query1)
//                .authoritiesByUsernameQuery(query2);
//    }
}
