package com.customer.service.com.customer.serviceApp.service;

import com.customer.service.com.customer.serviceApp.model.Customer;
import com.customer.service.com.customer.serviceApp.repository.CustomerRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> saveAll(List<Customer> customers){
        return customerRepository.saveAll(customers);
    }
    public Optional<Customer> getCustById(Integer id){
        return customerRepository.findById(id);
    }

    public Customer saveOrUpdate(Customer customer){
        return customerRepository.saveAndFlush(customer);
    }

    public String deleteById(Integer id) {

        JSONObject jsonObject = new JSONObject();
        try {
            customerRepository.deleteById(id);
            jsonObject.put("message", "Customer deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
