package com.vtxlab.demo.demoshopping.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vtxlab.demo.demoshopping.model.Customer;
import com.vtxlab.demo.demoshopping.model.CustomerDatabase;
import com.vtxlab.demo.demoshopping.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Override
  public Customer create(String name, String email, LocalDate dob) {
    Customer customer = Customer.builder() //
        .name(name).email(email).dob(dob).build();
    CustomerDatabase.add(customer);
    return customer;
  }

  @Override
  public Optional<Customer> find(long customerid) {
    return CustomerDatabase.find(customerid);
  }

  @Override
  public Customer remove(String customerId) {
    long temp = Long.valueOf(customerId);
    return CustomerDatabase.remove(temp);
  }

  @Override
  public Customer update(String id, Customer customer) {
    long temp = Long.valueOf(id);
    return CustomerDatabase.update(temp, customer);
  }

  @Override
  public Customer patchEmail(String id, String email) {
    long temp = Long.valueOf(id);
    return CustomerDatabase.patchEmail(temp, email);
  }

  @Override
  public Customer patchName(String id, String name) {
    long temp = Long.valueOf(id);
    return CustomerDatabase.patchName(temp, name);
  }

}
