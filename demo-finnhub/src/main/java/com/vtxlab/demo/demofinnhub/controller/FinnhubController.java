package com.vtxlab.demo.demofinnhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.demo.demofinnhub.model.CompanyDTO;

public interface FinnhubController {

  @GetMapping(value = "/stock")
  public CompanyDTO getCompanyProfile(@RequestParam(name = "symbol") String symbol);
}
