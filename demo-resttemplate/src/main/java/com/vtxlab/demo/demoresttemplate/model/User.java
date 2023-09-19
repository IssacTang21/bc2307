package com.vtxlab.demo.demoresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor // Jaskson
@Getter
public class User {
  private int id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  @Getter
  public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    public class Geo {
      private String lat;
      private String lng;
    }

  }

  @Getter
  public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
