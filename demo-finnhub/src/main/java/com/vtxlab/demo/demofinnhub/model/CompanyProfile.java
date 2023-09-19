package com.vtxlab.demo.demofinnhub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompanyProfile {
  private String country;
  private String companyName;
  private String ipoDate;
  private String logo;
  private double marketCap;
  private String currency;
}
