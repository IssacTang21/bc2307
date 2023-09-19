package com.vtxlab.demo.demofinnhub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class Company {
  private String country;
  private String currency;
  private String estimateCurrency;
  private String exchange;
  private String finnhubIndustry;
  private String ipo;
  private String logo;
  private String marketCapitalization;
  private String name;
  private String phone;
  private String shareOutstanding;
  private String ticker;
  private String weburl;

}
