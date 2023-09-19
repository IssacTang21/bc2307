package com.vtxlab.demo.demofinnhub.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.demofinnhub.controller.FinnhubController;
import com.vtxlab.demo.demofinnhub.mapper.CompanyMapper;
import com.vtxlab.demo.demofinnhub.mapper.CompanyProfileMapper;
import com.vtxlab.demo.demofinnhub.model.Company;
import com.vtxlab.demo.demofinnhub.model.CompanyDTO;
import com.vtxlab.demo.demofinnhub.model.CompanyProfile;
import com.vtxlab.demo.demofinnhub.model.Stock;
import com.vtxlab.demo.demofinnhub.service.FinnhubService;

@RestController
@RequestMapping(value = "/api/v1")
public class FinnhubControllerImpl implements FinnhubController {

  @Autowired
  FinnhubService finnhubService;

  @Override
  public CompanyDTO getCompanyProfile(String symbol) {
    Company company = finnhubService.getCompanyProfile(symbol);
    Stock stock = finnhubService.getStock(symbol);
    CompanyProfile companyProfile = CompanyProfileMapper.map(company);
    return CompanyMapper.map(companyProfile, stock);
  }
}
