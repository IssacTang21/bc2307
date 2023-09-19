package com.vtxlab.demo.demohelloworld.service.impl;

import org.springframework.stereotype.Service;

import com.vtxlab.demo.demohelloworld.service.HelloworldService;

@Service
public class HelloworldServiceImpl implements HelloworldService {

  // int age;

  @Override
  public String generate(int x) {
    if (x > 100)
      return "hello world";
    return "ABC";
  }

}
