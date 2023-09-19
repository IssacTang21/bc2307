package com.vtxlab.demo.demohelloworld.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtxlab.demo.demohelloworld.controller.HelloworldController;
import com.vtxlab.demo.demohelloworld.service.impl.HelloworldServiceImpl;

@Controller
@ResponseBody
@RequestMapping(value = "/api/v1") // version 1 api set
public class HelloworldControllerImpl implements HelloworldController {

  @Autowired //
  HelloworldServiceImpl helloworldServiceimpl;

  @Override
  public String helloworld() {

    return helloworldServiceimpl.generate(102);
  }
}
