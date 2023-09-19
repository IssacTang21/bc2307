package com.vtxlab.demo.demofinnhub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.demo.demofinnhub.infra.BusinessException;
import com.vtxlab.demo.demofinnhub.infra.Code;
import com.vtxlab.demo.demofinnhub.infra.Protocal;
import com.vtxlab.demo.demofinnhub.mapper.CompanyMapper;
import com.vtxlab.demo.demofinnhub.mapper.CompanyProfileMapper;
import com.vtxlab.demo.demofinnhub.model.Company;
import com.vtxlab.demo.demofinnhub.model.CompanyDTO;
import com.vtxlab.demo.demofinnhub.model.CompanyProfile;
import com.vtxlab.demo.demofinnhub.model.Stock;
import com.vtxlab.demo.demofinnhub.service.FinnhubService;

@Service
public class FinnhubServiceImpl implements FinnhubService {

  @Autowired
  private RestTemplate restTemplate;

  @Value(value = "${api.finnhub.domain}")
  private String finDomain;

  @Value(value = "${api.finnhub.endpoint.profile}")
  private String profile2Endpoint;

  @Value(value = "${api.finnhub.endpoint.quote}")
  private String quoteEndpoint;

  @Override
  public CompanyDTO getCompanyDTO(String symbol) throws Exception {
    Company company = getCompanyProfile(symbol);
    Stock stock = getStock(symbol);
    CompanyProfile companyProfile = CompanyProfileMapper.map(company);
    return CompanyMapper.map(companyProfile, stock);
  }

  @Override
  public Stock getStock(String symbol) throws BusinessException {
    String url = UriComponentsBuilder.newInstance()
        .scheme(Protocal.HTTPS.name())
        .host(finDomain)
        .path(quoteEndpoint)
        .queryParam("symbol", symbol)
        .queryParam("token", "ck4fib1r01qus81pv2vgck4fib1r01qus81pv300")
        .toUriString();
    System.out.println("url=" + url);

    try {
      Stock stock = restTemplate.getForObject(url, Stock.class);
      return stock;
    } catch (RestClientException e) {
      throw new BusinessException(Code.SYMBOL_NOTFOUND);
    }

  }

  @Override
  public Company getCompanyProfile(String symbol) throws BusinessException {
    String url = UriComponentsBuilder.newInstance()
        .scheme(Protocal.HTTPS.name())
        .host(finDomain)
        .path(profile2Endpoint)
        .queryParam("symbol", symbol)
        .queryParam("token", "ck4fib1r01qus81pv2vgck4fib1r01qus81pv300")
        .toUriString();
    System.out.println("url=" + url);

    try {
      Company company = restTemplate.getForObject(url, Company.class);
      return company;
    } catch (RestClientException e) {
      throw new BusinessException(Code.SYMBOL_NOTFOUND);
    }

  }
}
