package com.example.spring.with.jwt.token.config;

import com.example.spring.with.jwt.token.model.Customer;
import com.example.spring.with.jwt.token.repository.Customer_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//for jwt token using DAO implementation use this class--->

//@Service
//public class User_details implements UserDetailsService {

//    @Autowired
//   private Customer_Repo customer_repo;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        String userName, password = null;
////        List<GrantedAuthority> authorities = null;
////        List<Customer> customer = customer_repo.findByemail(username);
////        if (customer.size() == 0) {
////            throw new UsernameNotFoundException("User details not found for the user : " + username);
////        } else{
////            userName = customer.get(0).getEmail();
////            password = customer.get(0).getPwd();
////            authorities = new ArrayList<>();
////            authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
////        }
////        return new User(username,password,authorities);
////    }
//}
