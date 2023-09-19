package com.vtxlab.demo.demofinnhub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Stock {
  private String c;
  private String d;
  private String dp;
  private String h;
  private String l;
  private String o;
  private String pc;

}
