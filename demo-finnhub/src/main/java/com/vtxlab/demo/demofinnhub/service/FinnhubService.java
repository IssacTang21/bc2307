package com.vtxlab.demo.demofinnhub.service;

import com.vtxlab.demo.demofinnhub.model.Company;
import com.vtxlab.demo.demofinnhub.model.Stock;

public interface FinnhubService {

  Company getCompanyProfile(String symbol);

  Stock getStock(String symbol);
}
