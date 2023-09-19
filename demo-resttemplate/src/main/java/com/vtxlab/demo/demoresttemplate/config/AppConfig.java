package com.vtxlab.demo.demoresttemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig { // bean

  /**
   * Resttemplate is a tool/ class (library) to invoke third
   * 
   * @return
   */
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
