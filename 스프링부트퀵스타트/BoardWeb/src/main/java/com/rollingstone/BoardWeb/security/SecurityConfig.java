package com.rollingstone.BoardWeb.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig
{
    private final SecurityUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.userDetailsService(userDetailsService);

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/system/**").permitAll()
                .antMatchers("/board/**").authenticated()
                .antMatchers("/admin").hasRole("ADMIN");
        http.formLogin().loginPage("/system/login")
                .defaultSuccessUrl("/board/getBoardList", true);
        http.sessionManagement();
        http.exceptionHandling().accessDeniedPage("/system/accessDenied");
        http.logout().logoutUrl("/system/logout")
                .invalidateHttpSession(true).logoutSuccessUrl("/");
        return http.build();
    }
}