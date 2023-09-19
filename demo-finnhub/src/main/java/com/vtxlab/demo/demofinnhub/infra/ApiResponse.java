package com.vtxlab.demo.demofinnhub.infra;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse<T> {
  @JsonProperty("number")
  private int code;
  private String message;
  private T data; // attribute name by default same as json field name after serialization

  public int getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  public static <T> ApiResponseBuilder<T> builder() {
    return new ApiResponseBuilder<>();
  }

  private ApiResponse(ApiResponseBuilder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static class ApiResponseBuilder<T> {
    private int code;
    private String message;
    private T data;

    public ApiResponseBuilder<T> status(Code code) {
      this.code = code.getCode();
      this.message = code.getDescription();
      return this;
    }

    public ApiResponseBuilder<T> data(T data) {
      this.data = data;
      return this;
    }

    public ApiResponse<T> build() {
      if (this.code == 0 || this.message == null)
        throw new RuntimeException();
      return new ApiResponse<>(this);
    }

    public ApiResponseBuilder<T> ok() {
      this.code = Code.OK.getCode();
      this.message = Code.OK.getDescription();
      return this;
    }
  }
}

// {
// "code" : 200
// "message" : "OK" ,
// "error" : [

// ],
// "data" : [
// "", ""
// ],
// }