package com.vtxlab.demo.demofinnhub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.demo.demofinnhub.infra.Protocal;
import com.vtxlab.demo.demofinnhub.model.Company;
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
  public Company getCompanyProfile(String symbol) {
    String url = UriComponentsBuilder.newInstance()
        .scheme(Protocal.HTTPS.name())
        .host(finDomain)
        .path(profile2Endpoint)
        .queryParam("symbol", symbol)
        .queryParam("token", "ck4fib1r01qus81pv2vgck4fib1r01qus81pv300")
        .toUriString();
    System.out.println("url=" + url);
    Company company = restTemplate.getForObject(url, Company.class);
    return company;
  }

  @Override
  public Stock getStock(String symbol) {
    String url = UriComponentsBuilder.newInstance()
        .scheme(Protocal.HTTPS.name())
        .host(finDomain)
        .path(quoteEndpoint)
        .queryParam("symbol", symbol)
        .queryParam("token", "ck4fib1r01qus81pv2vgck4fib1r01qus81pv300")
        .toUriString();
    System.out.println("url=" + url);
    Stock stock = restTemplate.getForObject(url, Stock.class);
    return stock;
  }

}
