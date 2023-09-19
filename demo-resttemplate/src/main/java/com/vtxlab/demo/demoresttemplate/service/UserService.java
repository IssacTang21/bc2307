package com.vtxlab.demo.demoresttemplate.service;

import java.util.List;

import com.vtxlab.demo.demoresttemplate.infra.BusinessException;
import com.vtxlab.demo.demoresttemplate.model.User;

public interface UserService {

  List<User> findUsers() throws BusinessException;

  User findOneUser(String id) throws BusinessException;
}
