package com.vtxlab.demo.demofinnhub.infra;

import lombok.Getter;

@Getter
public enum Code {
  OK(20000, "OK"),
  // 40000-49999
  NOTFOUND(40000, "Resource NOT FOUND"),
  SYMBOL_NOTFOUND(40001, "Finnhub RestClientException"),
  // Server
  SERVER_TIMEOUT(50000, "Server Timeout"),
  ;

  int code;
  String description;

  private Code(int code, String description) {
    this.code = code;
    this.description = description;
  }
}
