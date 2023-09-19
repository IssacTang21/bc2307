package com.vtxlab.demo.demoshopping.service;

import java.time.LocalDate;
import java.util.Optional;

import com.vtxlab.demo.demoshopping.model.Customer;

public interface CustomerService {

  Customer create(String name, String email, LocalDate dob);

  Optional<Customer> find(long customerId);

  Customer remove(String customerId);

  Customer update(String id, Customer customer);

  Customer patchEmail(String id, String email);

  Customer patchName(String id, String name);
}
