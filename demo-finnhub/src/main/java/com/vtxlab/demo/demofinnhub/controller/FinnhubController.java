package com.vtxlab.demo.demofinnhub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.demo.demofinnhub.infra.ApiResponse;
import com.vtxlab.demo.demofinnhub.model.CompanyDTO;

public interface FinnhubController {

  @GetMapping(value = "/stock")
  public ResponseEntity<ApiResponse<CompanyDTO>> getCompanyDTO(@RequestParam(name = "symbol") String symbol)
      throws Exception;
}
