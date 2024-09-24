package portfolio.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.boot.actuate.data.mongo.MongoHealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDatabaseFactory;
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
import org.springframework.security.web.SecurityFilterChain;

import com.mongodb.client.internal.MongoClientImpl;


@Configuration
public class SecurityConfig {

    
    private AuthenticationProvider mongoAuth;
    // injection by setter injection.
    public SecurityConfig(MongoAuthenticationProvider mn){
        this.mongoAuth=mn;
    }

    @Profile("dev")
    @Bean
    public SecurityFilterChain filterDev(HttpSecurity http) throws Exception{

         http.authorizeHttpRequests(authorize->authorize.requestMatchers("/userAccounts/v1/users").hasAuthority("ADMIN").anyRequest().permitAll())
         .formLogin(Customizer.withDefaults())
         .httpBasic(Customizer.withDefaults());
   
       // http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
    
        //disables the CSRF validation.
        http.csrf(AbstractHttpConfigurer::disable); 
        return http.build();
    }

    @Profile("!dev")
    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authorize->authorize.requestMatchers("/userAccounts/v1/user").permitAll()
                .requestMatchers("/api/v1/videoConverter").permitAll()
                .requestMatchers("/api/v1/productsV2").permitAll()
                .requestMatchers("/api/v1/getAllAccounts").permitAll()
                .anyRequest().authenticated()
        );

        http.formLogin(flc->flc.disable());
        http.httpBasic(Customizer.withDefaults());
        // disabled CSRF tokens.
         http.csrf(AbstractHttpConfigurer::disable); 
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(mongoAuth);
        return authenticationManagerBuilder.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    

}
