package online.shopping.system.customer_service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity httpSecurity){
        return httpSecurity
                .authorizeExchange(exchange ->
                        exchange.pathMatchers("/customers").permitAll()

                )
                .authorizeExchange(exchange -> exchange
                        .anyExchange().authenticated()

                )

                .oauth2Login(Customizer.withDefaults())
                .build();
    }
}
