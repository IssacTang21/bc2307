package com.vtxlab.demo.demofinnhub.service;

import com.vtxlab.demo.demofinnhub.infra.BusinessException;
import com.vtxlab.demo.demofinnhub.model.Company;
import com.vtxlab.demo.demofinnhub.model.CompanyDTO;
import com.vtxlab.demo.demofinnhub.model.Stock;

public interface FinnhubService {

  Company getCompanyProfile(String symbol) throws BusinessException;

  Stock getStock(String symbol) throws BusinessException;

  CompanyDTO getCompanyDTO(String symbol) throws Exception;
}
