package com.vtxlab.demo.democalculator.config;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Member of @Component
public class BeanCreater {

  @Bean(name = "arrayList")
  public List<String> createArrayList() {
    return new ArrayList<>();
  }

  @Bean(name = "linkedList")
  public List<String> createLinkList() {
    return new LinkedList<>();
  }
}
