package com.jalal.security_stepthree.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        (authorize)-> authorize
                                .requestMatchers("/css/**","/js/**","/webfonts/**").permitAll()
                                .requestMatchers("/","/home").permitAll()
                                .requestMatchers("/user").hasRole("USER")
                                .requestMatchers("/admin").hasRole("ADMIN")

                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/home")
                        .permitAll()

                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/home")
                        .permitAll()

                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService (){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("jalal")
                .password("123")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
}
