package com.vtxlab.demo.demoresttemplate.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.demoresttemplate.controller.UserController;
import com.vtxlab.demo.demoresttemplate.infra.ApiResponse;
import com.vtxlab.demo.demoresttemplate.mapper.UserMapper;
import com.vtxlab.demo.demoresttemplate.model.User;
import com.vtxlab.demo.demoresttemplate.model.UserDTO;
import com.vtxlab.demo.demoresttemplate.service.UserService;

@RestController // controller + ResponseBody
@RequestMapping(value = "/api/v1")
public class UserControllerImpl implements UserController {

  @Autowired
  UserService userService;

  @Override
  public ResponseEntity<ApiResponse<List<UserDTO>>> findUsers() throws Exception {
    List<User> users = userService.findUsers();

    // Conversion (user ->userDTO)
    List<UserDTO> userDTOs = users.stream() //
        .map(user -> UserMapper.map(user))
        .collect(Collectors.toList());

    ApiResponse<List<UserDTO>> response = ApiResponse.<List<UserDTO>>builder() //
        // .status(Code.OK)
        .ok()
        .data(userDTOs).build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public User findOneUser(String id) throws Exception {
    return userService.findOneUser(id);
  }
}
