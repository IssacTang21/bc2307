package com.vtxlab.demo.demoshopping.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDatabase {
  public static List<Customer> customers = new ArrayList<>();

  public static void add(Customer customer) {
    customers.add(customer);
  }

  public static Optional<Customer> find(long id) {
    return customers.stream().filter(customer -> customer.getId() == id)
        .findFirst();
  }

  public static Customer remove(long id) {
    Optional<Customer> customer = find(id);
    if (!customer.isPresent())
      return null;
    CustomerDatabase.customers.remove(customer.get());
    return customer.get();
  }

  public static Customer update(long id, Customer newCustomer) {
    if (!find(id).isPresent())
      return null;
    customers.stream().filter(customer -> customer.getId() == id)
        .forEach(e -> {
          e.setDob(newCustomer.getDob());
          e.setEmail(newCustomer.getEmail());
          e.setName(newCustomer.getName());
        });
    return newCustomer;
  }

  public static Customer patchEmail(long id, String email) {
    Optional<Customer> customer = find(id);
    if (!find(id).isPresent())
      return null;
    customer.get().setEmail(email);
    customers.stream().filter(c -> c.getId() == id)
        .forEach(e -> {
          e.setEmail(email);
        });
    return customer.get();
  }

  public static Customer patchName(long id, String name) {
    Optional<Customer> customer = find(id);
    if (!find(id).isPresent())
      return null;
    customer.get().setName(name);
    customers.stream().filter(c -> c.getId() == id)
        .forEach(e -> {
          e.setName(name);
        });
    return customer.get();
  }
}
