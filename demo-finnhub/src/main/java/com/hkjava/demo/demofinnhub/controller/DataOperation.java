package com.hkjava.demo.demofinnhub.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.entity.StockPrice;
import com.hkjava.demo.demofinnhub.infra.ApiResp;
import com.hkjava.demo.demofinnhub.model.dto.web.resp.StockDTO;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


public interface DataOperation {

  @Operation(summary = "Get All Stock Profiles",
      description = "This endpoint is to get all Company Profile from database",
      tags = "Find All Stock Profiles")
  @ApiResponses({
      @ApiResponse(responseCode = "200",
          content = {@Content(schema = @Schema(implementation = ApiResp.class),
              mediaType = "application/json")}),
      @ApiResponse(responseCode = "404",
          content = {@Content(schema = @Schema())}),
      @ApiResponse(responseCode = "500",
          content = {@Content(schema = @Schema())})})
  @GetMapping(value = "/data/stocks")
  @ResponseStatus(value = HttpStatus.OK)
  List<Stock> findAll();

  @Operation(summary = "Get Stock List By Country and Market Cap",
      description = "This endpoint is to insert stock data into database",
      tags = "Get Stock List")
  @ApiResponses({
      @ApiResponse(responseCode = "200",
          content = {@Content(schema = @Schema(implementation = ApiResp.class),
              mediaType = "application/json")}),
      @ApiResponse(responseCode = "404",
          content = {@Content(schema = @Schema())}),
      @ApiResponse(responseCode = "500",
          content = {@Content(schema = @Schema())})})
  @GetMapping(value = "/data/stock/country/{country}/marketcap/{marketCap}")
  @ResponseStatus(value = HttpStatus.OK)
  List<Stock> findByCountryAndMarketCap(@PathVariable String country,
      @PathVariable double marketCap);

  @Hidden
  @PostMapping(value = "/data/stock")
  @ResponseStatus(value = HttpStatus.OK)
  Stock save(@RequestBody Stock stock);

  @Hidden
  @DeleteMapping(value = "/data/stock/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  void deleteById(@PathVariable Long id);

  @Hidden
  @PutMapping(value = "/data/stock/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  void updateById(@PathVariable Long id, @RequestBody Stock stock);

  @Hidden
  @PatchMapping(value = "/data/stock/id/{id}/companyname/{companyName}")
  @ResponseStatus(value = HttpStatus.OK)
  void updateCompanyNameById(@PathVariable Long id,
      @PathVariable String companyName);

  @Hidden
  @PostMapping("/data/stock/{id}/price")
  @ResponseStatus(value = HttpStatus.OK)
  StockPrice save(@PathVariable Long id, @RequestBody StockPrice stockPrice);

}
