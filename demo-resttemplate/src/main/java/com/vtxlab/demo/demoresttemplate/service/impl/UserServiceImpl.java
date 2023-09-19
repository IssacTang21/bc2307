package com.vtxlab.demo.demoresttemplate.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.demo.demoresttemplate.infra.BusinessException;
import com.vtxlab.demo.demoresttemplate.infra.Code;
import com.vtxlab.demo.demoresttemplate.infra.Protocal;
import com.vtxlab.demo.demoresttemplate.model.User;
import com.vtxlab.demo.demoresttemplate.service.UserService;

@Service
public class UserServiceImpl implements UserService { // bean

  @Autowired
  private RestTemplate restTemplate; // from context

  @Value(value = "${api.jsonplaceholder.domain}") // find in yml, if doesn't find , error
  private String jphDomain; // jsonplaceholder.typicode.com // from yml

  @Value(value = "${api.jsonplaceholder.endpoint.user}")
  private String userEndpoint; // users // from yml

  @Override
  public List<User> findUsers() throws BusinessException {
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Protocal.HTTPS.name()) //
        .host(jphDomain) //
        .path(userEndpoint) //
        .toUriString();
    System.out.println("url=" + url);

    // Invoke API + Deserialization (JSON -> Object)
    try {
      User[] users = restTemplate.getForObject(url, User[].class);
      return Arrays.asList(users);
      // return null;
    } catch (RestClientException e) {
      throw new BusinessException(Code.JPH_NOTFOUND);
    }
  }

  @Override
  public User findOneUser(String id) throws BusinessException {
    int temp = Integer.valueOf(id);
    Optional<User> user = findUsers().stream().filter(e -> e.getId() == temp).findFirst();
    if (user.isPresent())
      return user.get();
    else
      return null;
  }

}
