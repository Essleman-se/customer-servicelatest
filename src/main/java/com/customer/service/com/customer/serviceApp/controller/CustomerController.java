package com.customer.service.com.customer.serviceApp.controller;


import com.customer.service.com.customer.serviceApp.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/customer")
public class CustomerController {

	static List<Customer> customers = new ArrayList<>();
	
	static {
        customers.add(new Customer("cu01", "Semira","Yesuf","ssss@uu","22222","great","STD"));
        customers.add(new Customer("cu02", "Solo","Abegazu","ssss@uu","22222","great","STD"));
        customers.add(new Customer("cu03", "Esain","Endeyu","ssss@uu","22222","great","STD"));
        customers.add(new Customer("cu04", "Endeshaw","Abebe","ssss@uu","22222","great","GD"));
        customers.add(new Customer("cu05", "Sebsb","Shekfe","ssss@uu","22222","great","PLT"));
        customers.add(new Customer("cu06", "Bihonegn","Zeynu","ssss@uu","22222","great","STDP"));
	}
	
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
        


        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/add")    
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
    	
    	customers.add(customer);
    	
    	return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){

        customers.add(customer);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
