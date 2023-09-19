package com.vtxlab.demo.demofinnhub.mapper;

import com.vtxlab.demo.demofinnhub.model.CompanyDTO;
import com.vtxlab.demo.demofinnhub.model.CompanyProfile;
import com.vtxlab.demo.demofinnhub.model.Stock;

public class CompanyMapper {
  public static CompanyDTO map(CompanyProfile companyProfile, Stock stock) {

    return CompanyDTO.builder()
        .companyProfile(companyProfile)
        .currentPrice(Double.valueOf(stock.getC()))
        .dayHigh(Double.valueOf(stock.getH()))
        .dayLow(Double.valueOf(stock.getL()))
        .dayOpen(Double.valueOf(stock.getO()))
        .prevDayClose(Double.valueOf(stock.getPc()))
        .build();
  }
}
