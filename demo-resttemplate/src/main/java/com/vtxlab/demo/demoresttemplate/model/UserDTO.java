package com.vtxlab.demo.demoresttemplate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor // Jaskson
@Getter
@Builder
public class UserDTO {
  private int id;
  private String name;
  @JsonProperty("X")
  private String username;
}
