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
            authorization.requestMatchers("/profile").authenticated();
            authorization.anyRequest().permitAll();
        });
        http.formLogin().loginPage("/login").loginProcessingUrl("/process_login").failureUrl("/login?error").and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
        return http.build();
    }
}
