package com.vtxlab.demo.demoshopping.controller.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.demoshopping.controller.CustomerOperation;
import com.vtxlab.demo.demoshopping.model.Customer;
import com.vtxlab.demo.demoshopping.service.CustomerService;

@RestController
@RequestMapping(value = "/api/v1")
public class CutomerController implements CustomerOperation {

  @Autowired
  CustomerService customerService;

  @Override
  public Customer create(String name, String email, LocalDate dob) {
    return customerService.create(name, email, dob);
  }

  @Override
  public Customer find(String customerId) {
    if (!customerId.isBlank()) {
      try {
        long id = Integer.valueOf(customerId);
        return customerService.find(id).orElse(null);
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
  }

  @Override
  public Customer remove(String customerId) {
    return customerService.remove(customerId);
  }

  @Override
  public Customer update(String id, Customer customer) {
    return customerService.update(id, customer);
  }

  @Override
  public Customer patchEmail(String id, String email) {
    return customerService.patchEmail(id, email);
  }

  @Override
  public Customer patchName(String id, String name) {
    return customerService.patchName(id, name);
  }

  // @Override
  // public Customer
}
