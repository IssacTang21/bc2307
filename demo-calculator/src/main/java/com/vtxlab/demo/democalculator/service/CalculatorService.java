package com.vtxlab.demo.democalculator.service;

import java.util.List;

public interface CalculatorService {
  /**
   * 
   * @param x
   * @param y
   * @return
   */
  int add(int x, int y);

  /**
   * A method to subtract x to y
   * 
   * @param x - A int value
   * @param y -
   * @return
   */
  int subtract(int x, int y);

  public List<String> getStrings();

}
