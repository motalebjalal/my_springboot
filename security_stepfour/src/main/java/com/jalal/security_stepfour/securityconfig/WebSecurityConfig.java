package com.jalal.security_stepfour.securityconfig;


import com.jalal.security_stepfour.error_handle.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig {
    @Autowired
    private final UserDetailsService userDetailsService;

    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        (authorize)-> authorize
                                .requestMatchers("/css/**","/js/**","/webfonts/**").permitAll()
                                .requestMatchers("/","/home").permitAll()
                                .requestMatchers("/form").permitAll()
                                .requestMatchers("/create").permitAll()
                                .requestMatchers("/user").hasAuthority("ROLE_USER")
                                .requestMatchers("/admin").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/error/403").permitAll()
                                /*.requestMatchers("/admin").hasRole("ADMIN")*/

                )
                .formLogin(form -> form
                        .loginPage("/home")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/home")
                        .permitAll()


                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()

                )
                .exceptionHandling(exceptions -> exceptions
                        .accessDeniedHandler(accessDeniedHandler()) // access denied 403 error handler

                );


        return http.build();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler(); // Custom access denied handler class
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
       DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
       provider.setPasswordEncoder(passwordEncoder());
       provider.setUserDetailsService(userDetailsService);

       return provider;
    }

}
