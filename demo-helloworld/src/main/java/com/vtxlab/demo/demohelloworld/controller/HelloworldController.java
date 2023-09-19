package com.vtxlab.demo.demohelloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface HelloworldController {

  @GetMapping(value = "/helloworld")
  String helloworld();
}
