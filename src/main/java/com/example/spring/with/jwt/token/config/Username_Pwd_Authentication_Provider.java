package com.example.spring.with.jwt.token.config;

import com.example.spring.with.jwt.token.model.Customer;
import com.example.spring.with.jwt.token.repository.Customer_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//for inbuilt authentication without dao implementation use this class---->
@Component
public class Username_Pwd_Authentication_Provider implements AuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Customer_Repo customer_repo;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String username=authentication.getName();
       String pwd=authentication.getCredentials().toString();
       List<Customer> customer =customer_repo.findByemail(username);
       if(customer.size()>0)
       {
           if(passwordEncoder.matches(pwd,customer.get(0).getPwd()))
           {
               List<GrantedAuthority> authorities =new ArrayList<GrantedAuthority>();
               authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
               return new UsernamePasswordAuthenticationToken(username,pwd,authorities);
           }
           else
           {
            throw new BadCredentialsException("password didn't match!");

           }

       }
       else
       {
           throw new BadCredentialsException("No user registered with this details!");
       }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));

    }
}
