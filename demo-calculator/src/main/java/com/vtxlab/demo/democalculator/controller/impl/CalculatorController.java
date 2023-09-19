package com.vtxlab.demo.democalculator.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.democalculator.controller.CalculatorOperation;
import com.vtxlab.demo.democalculator.service.CalculatorService;

// @Controller
// @ResponseBody
@RestController // @Controller + @ResponseBody
@RequestMapping(value = "/api/v1")
public class CalculatorController implements CalculatorOperation {

  @Autowired
  CalculatorService calculatorService;

  // @Autowired
  // List<String> strings;

  @Override
  public List<String> getStrings() {
    return calculatorService.getStrings();
  }

  @Override
  public Integer add(int salary, int bonus, String divided) {
    int d = 0;
    try {
      d = Integer.valueOf(divided);
    } catch (NumberFormatException e) {
      d = 0;
    }

    return calculatorService.add(salary + bonus, d);
  }

  @Override
  public Integer subtract(int x, int y, String z) {
    int d = 0;
    try {
      d = Integer.valueOf(z);
    } catch (NumberFormatException e) {
      d = 0;
    }
    return calculatorService.subtract(x - y, d);
  }
}
