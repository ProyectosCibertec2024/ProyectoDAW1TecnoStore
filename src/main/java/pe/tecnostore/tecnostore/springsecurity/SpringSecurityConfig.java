package pe.tecnostore.tecnostore.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((auth) -> auth

                    .requestMatchers("/principal","/login").authenticated()
                    .anyRequest().permitAll() )

                .formLogin(form -> form.loginPage("/login")
                        .permitAll().defaultSuccessUrl("/principal"))

                .logout(log -> log
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login").permitAll());

        return http.build();
    }
}
