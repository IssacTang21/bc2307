package com.vtxlab.demo.demofinnhub.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vtxlab.demo.demofinnhub.infra.ApiResponse;
import com.vtxlab.demo.demofinnhub.infra.Code;

@RestControllerAdvice // @ResponseBody + @ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = SYMException.class)
  public ResponseEntity<ApiResponse<List<Void>>> getSYMExceptionHandler() {
    ApiResponse<List<Void>> response = ApiResponse.<List<Void>>builder() //
        .status(Code.SYMBOL_NOTFOUND)
        .data(null).build();
    return ResponseEntity.badRequest().body(response);

  }
}
