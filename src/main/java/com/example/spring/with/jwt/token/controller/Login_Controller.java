package com.example.spring.with.jwt.token.controller;

import com.example.spring.with.jwt.token.model.Customer;
import com.example.spring.with.jwt.token.repository.Customer_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login_Controller {

    @Autowired
    Customer_Repo customer_repo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registeruser")
    public ResponseEntity<String> addNewUser(@RequestBody  Customer customer)
    { Customer savedCustomer = null;
        ResponseEntity response = null;
        try {
            String hashPwd = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPwd);
            savedCustomer = customer_repo.save(customer);

            if (savedCustomer.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + ex.getMessage());
        }
        return response;
    }

}
