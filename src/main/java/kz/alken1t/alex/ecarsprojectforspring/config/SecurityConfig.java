package kz.alken1t.alex.ecarsprojectforspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests(authorization -> {
            authorization.requestMatchers("/asfdsf").authenticated();
            authorization.anyRequest().permitAll();
        });
        http.formLogin().defaultSuccessUrl("/fsdf");
        return http.build();
    }
}
