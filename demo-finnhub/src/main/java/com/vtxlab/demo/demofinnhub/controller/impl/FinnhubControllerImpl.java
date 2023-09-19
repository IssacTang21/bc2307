package com.vtxlab.demo.demofinnhub.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.demofinnhub.controller.FinnhubController;
import com.vtxlab.demo.demofinnhub.infra.ApiResponse;
import com.vtxlab.demo.demofinnhub.model.CompanyDTO;
import com.vtxlab.demo.demofinnhub.service.FinnhubService;

@RestController
@RequestMapping(value = "/api/v1")
public class FinnhubControllerImpl implements FinnhubController {

  @Autowired
  FinnhubService finnhubService;

  @Override
  public ResponseEntity<ApiResponse<CompanyDTO>> getCompanyDTO(String symbol) throws Exception {
    CompanyDTO companyDTO = finnhubService.getCompanyDTO(symbol);

    ApiResponse<CompanyDTO> apiResponse = ApiResponse.<CompanyDTO>builder()
        .ok().data(companyDTO).build();

    return ResponseEntity.ok().body(apiResponse);
  }
}
