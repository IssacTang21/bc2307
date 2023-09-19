package com.vtxlab.demo.democalculator.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.democalculator.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

  @Autowired
  @Qualifier(value = "arrayList")
  List<String> strings;

  @Override
  public List<String> getStrings() {
    strings.add("abc");
    strings.add("def");
    strings.add("ghi");
    return strings;
  }

  @Override
  public int add(int x, int y) {
    return x + y;
  }

  @Override
  public int subtract(int x, int y) {
    return x - y;
  }
}
