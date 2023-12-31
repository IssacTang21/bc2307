package com.vtxlab.demo.demoshopping.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.demo.demoshopping.model.Customer;

public interface CustomerOperation {

  // "/customer" -> endpoint
  @PostMapping(value = "/customer") // noun, no verb
  Customer create(@RequestParam String name,
      @RequestParam String email, @RequestParam LocalDate dob);

  @GetMapping(value = "/customer/{id}") // noun, No verb
  Customer find(@PathVariable(name = "id") String customerId);

  // @PostMapping(value = "/customer2") // noun, no verb
  // Customer createCustomer(@RequestBody Customer customer);

  @DeleteMapping(value = "/customer/{id}") // noun, No verb
  Customer remove(@PathVariable(name = "id") String customerId);

  @PutMapping(value = "/customer/{id}") // Put -> table PK
  Customer update(@PathVariable(name = "id") String id, @RequestBody Customer customer);

  @PatchMapping(value = "/customer/id/{id}/email/{email}")
  Customer patchEmail(@PathVariable(name = "id") String id, @PathVariable String email);

  @PatchMapping(value = "/customer/id/{id}/name/{name}")
  Customer patchName(@PathVariable(name = "id") String id, @PathVariable String name);

}
