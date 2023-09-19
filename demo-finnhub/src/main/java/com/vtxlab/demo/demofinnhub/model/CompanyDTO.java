package com.vtxlab.demo.demofinnhub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompanyDTO {
  private CompanyProfile companyProfile;
  private double currentPrice;
  private double dayHigh;
  private double dayLow;
  private double dayOpen;
  private double prevDayClose;

}
