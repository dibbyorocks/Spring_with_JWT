package com.example.spring.with.jwt.token.repository;

import com.example.spring.with.jwt.token.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 //import org.springframework.data.relational.core.mapping.Table;
import java.util.List;


@Repository
public interface Customer_Repo  extends JpaRepository<Customer,Integer> {

    List<Customer> findByemail(String email);

    //List<Customer> getRole(String role);
}
