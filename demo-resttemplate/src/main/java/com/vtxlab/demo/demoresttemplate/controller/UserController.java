package com.vtxlab.demo.demoresttemplate.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.demo.demoresttemplate.infra.ApiResponse;
import com.vtxlab.demo.demoresttemplate.model.User;
import com.vtxlab.demo.demoresttemplate.model.UserDTO;

public interface UserController {

  @GetMapping(value = "/customer2")
  public ResponseEntity<ApiResponse<List<UserDTO>>> findUsers() throws Exception;

  @GetMapping(value = "/customer3")
  public User findOneUser(@RequestParam(name = "id") String id) throws Exception;
}
