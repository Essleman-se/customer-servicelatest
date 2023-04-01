package com.customer.service.com.customer.serviceApp.controller;


import com.customer.service.com.customer.serviceApp.exception.ApiRequestException;
import com.customer.service.com.customer.serviceApp.model.Customer;
import com.customer.service.com.customer.serviceApp.repository.CustomerRepository;
import com.customer.service.com.customer.serviceApp.service.CustomerService;

import java.lang.reflect.Field;
import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
	static List<Customer> customers = new ArrayList<>();
	
//	static {
//        customers.add(new Customer(001, "cu01", "Semira","Yesuf","ssss@uu","22222","great","STD"));
//        customers.add(new Customer(002, "cu02", "Solo","Abegazu","ssss@uu","22222","great","STD"));
//        customers.add(new Customer(003, "cu03", "Esain","Endeyu","ssss@uu","22222","great","STD"));
//        customers.add(new Customer(004, "cu04", "Endeshaw","Abebe","ssss@uu","22222","great","GD"));
//        customers.add(new Customer(005, "cu05", "Sebsb","Shekfe","ssss@uu","22222","great","PLT"));
//        customers.add(new Customer(006, "cu06", "Bihonegn","Zeynu","ssss@uu","22222","great","STDP"));
//	}
	
    @GetMapping(value = "/hellocustomer")
    public String hellowCustomer(){
        return "Hello Customers";
    }
    
    @GetMapping(value = "/")
    public ResponseEntity<String> hello(){

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    
    @PostMapping("/get/{id}")
    public ResponseEntity<Customer> findById(@PathVariable(required = false) Integer id){
        Optional<Customer> customer = customerService.getCustById(id);
        if (!customer.isPresent()){
            throw new ApiRequestException("Oops Customer NOT FOUND");
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }
    //RequestParam endpoint
    @PostMapping("/get")
    public ResponseEntity<Customer> findById2(@RequestParam Integer id){
        Optional<Customer> customer = customerService.getCustById(id);
        if (!customer.isPresent()){
            throw new ApiRequestException("Oops Customer NOT FOUND");
        }

        return new ResponseEntity(customer, HttpStatus.OK);
    }
    @PostMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> saveCustomer(@RequestBody List<Customer> customers){
    	
    	customerService.saveAll(customers);
    	
    	return new ResponseEntity(customers, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){

        //log.info("CustemerService - update");
        if (customer.getId() == null) {
            throw new ApiRequestException("Oops Customer ID not found, ID is required for update the data");
        } else {
            Customer updatedCustomer = customerService.saveOrUpdate(customer);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Customer> patch(@PathVariable Integer id,
                                          @RequestBody Map<Object, Object> fields) {
        Optional<Customer> cust = customerService.getCustById(id);
        if (cust.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Customer.class, (String)key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, cust.get(), value);
            });
            Customer updateCustomer = customerService.saveOrUpdate(cust.get());

            return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
        }
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        Optional<Customer> customer = customerService.getCustById(id);
        if (!customer.isPresent()){
            throw new ApiRequestException("Oops Customer NOT FOUND");
        }

        return new ResponseEntity<>(customerService.deleteById(id), HttpStatus.OK);
    }
}
