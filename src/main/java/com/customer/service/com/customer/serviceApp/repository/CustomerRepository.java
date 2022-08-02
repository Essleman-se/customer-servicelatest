package com.customer.service.com.customer.serviceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.service.com.customer.serviceApp.model.Customer;

import javax.swing.text.html.Option;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
