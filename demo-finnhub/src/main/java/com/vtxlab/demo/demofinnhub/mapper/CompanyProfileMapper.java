package com.vtxlab.demo.demofinnhub.mapper;

import com.vtxlab.demo.demofinnhub.model.Company;
import com.vtxlab.demo.demofinnhub.model.CompanyProfile;

public class CompanyProfileMapper {
  public static CompanyProfile map(Company company) {
    return CompanyProfile.builder()
        .country(company.getCountry())
        .companyName(company.getName())
        .ipoDate(company.getIpo())
        .logo(company.getLogo())
        .marketCap(Double.valueOf(company.getMarketCapitalization()))
        .currency(company.getCurrency())
        .build();
  }
}
