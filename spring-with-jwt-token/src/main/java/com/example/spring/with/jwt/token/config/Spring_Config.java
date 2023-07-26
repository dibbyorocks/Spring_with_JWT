package com.example.spring.with.jwt.token.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class Spring_Config {
    @Bean

        //@Order(SecurityProperties.BASIC_AUTH_ORDER)
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((requests) ->
//                //requests.requestMatchers("/yourcards","/youraccount","/yourbalance").authenticated()  //for specific controller access
//                requests.requestMatchers("/notices","/contact","/register").permitAll())
//              //  requests.anyRequest().permitAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
        SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
            http.csrf((csrf) -> csrf.disable())
                    .authorizeHttpRequests((requests)->requests
                            .antMatchers("/youraccount","/yourbalance","/yourcards").authenticated()
                            .antMatchers("/notices","/contact","/registeruser").permitAll())
                           // requests.anyRequest().permitAll())
                    .formLogin(Customizer.withDefaults())
                    .httpBasic(Customizer.withDefaults());
            return http.build();

     }
//
    @Bean//for using Bcryptpassword encoder(needs high processing memory) use this --->
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
//    @Bean//not recommend for prod env as it is a plain text format
    //for normal standard security--->
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
}


