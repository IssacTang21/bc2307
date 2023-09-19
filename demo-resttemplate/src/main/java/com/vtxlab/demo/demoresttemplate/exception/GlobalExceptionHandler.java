package com.vtxlab.demo.demoresttemplate.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vtxlab.demo.demoresttemplate.infra.ApiResponse;
import com.vtxlab.demo.demoresttemplate.infra.Code;

@RestControllerAdvice // @ResponseBody + @ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = JPHException.class)
  public ResponseEntity<ApiResponse<List<Void>>> getJPHExceptionHandler() {
    ApiResponse<List<Void>> response = ApiResponse.<List<Void>>builder() //
        .status(Code.JPH_NOTFOUND)
        .data(null).build();
    return ResponseEntity.badRequest().body(response);
  }
}
