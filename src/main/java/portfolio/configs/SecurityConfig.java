package portfolio.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.FilterChain;

@Configuration
public class SecurityConfig {

    // private AuthenticationProvider mongoAuth;

    public SecurityConfig(){
  
    }

    /**
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {
        // http.authorizeHttpRequests(authorize->authorize.requestMatchers("/userAccounts/v1").permitAll()
        // .anyRequest().authenticated()).httpBasic(Customizer.withDefaults())
        // .formLogin(Customizer.withDefaults());

        http.authorizeHttpRequests(authorize->authorize.anyRequest().permitAll());
        

        // disabled CSRF tokens.
         http.csrf(AbstractHttpConfigurer::disable); 

        return http.build();
    }

    // authentication manager manages to load users where you want to
    // @Bean
    // public AuthenticationManager authManager(HttpSecurity http) throws Exception {
    //     AuthenticationManagerBuilder authenticationManagerBuilder = 
    //         http.getSharedObject(AuthenticationManagerBuilder.class);
    //     authenticationManagerBuilder.authenticationProvider(mongoAuth);
    //     return authenticationManagerBuilder.build();
    // }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
