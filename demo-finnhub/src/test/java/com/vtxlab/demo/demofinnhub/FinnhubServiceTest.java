package com.vtxlab.demo.demofinnhub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.vtxlab.demo.demofinnhub.model.Company;
import com.vtxlab.demo.demofinnhub.service.FinnhubService;

@SpringBootTest
public class FinnhubServiceTest {

  @Autowired
  FinnhubService finnhubService;

  @Mock
  RestTemplate restTemplate;

  @Test
  void testGetCompanyProfile() throws Exception {
    String url = "https://finnhub.io/api/v1/stock/profile2?symbol=ABC&token=ck4fib1r01qus81pv2vgck4fib1r01qus81pv300";
    Company company = new Company("HK", "HKD", "100", "99", "TECH", "1900-01-01", "ABC", "98", "APPLE", "123", "124",
        "ABCD", "ABC.COM");
    Mockito.when(restTemplate.getForObject(url, Company.class)).thenReturn(company);

    String symbol = "ABC";
    Company result = finnhubService.getCompanyProfile(symbol);
    Assertions.assertEquals(company, result);
  }
}
