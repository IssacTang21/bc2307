package com.vtxlab.demo.demofinnhub.infra;

public class BusinessException extends Exception {
  private int code;

  public BusinessException(Code code) {
    super(code.getDescription());
    this.code = code.getCode();
  }
}
