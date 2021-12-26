package com.customer.service.com.customer.serviceApp.controller;


import com.customer.service.com.customer.serviceApp.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping(value = "/hellocustomer")
    public String hellowCustomer(){

        return "Hello Customers";
    }
    
    @GetMapping(value = "/")
    public ResponseEntity<String> hello(){

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("cu01", "Semira","Yesuf","ssss@uu","22222","great","STD"));
        customers.add(new Customer("cu02", "Solo","Abegazu","ssss@uu","22222","great","STD"));
        customers.add(new Customer("cu03", "Esain","Endeyu","ssss@uu","22222","great","STD"));
        customers.add(new Customer("cu04", "Endeshaw","Abebe","ssss@uu","22222","great","GD"));
        customers.add(new Customer("cu05", "Sebsb","Shekfe","ssss@uu","22222","great","PLT"));
        customers.add(new Customer("cu06", "Bihonegn","Zeynu","ssss@uu","22222","great","STDP"));

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
