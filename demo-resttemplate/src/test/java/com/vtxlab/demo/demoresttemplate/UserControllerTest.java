package com.vtxlab.demo.demoresttemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.vtxlab.demo.demoresttemplate.model.User;
import com.vtxlab.demo.demoresttemplate.service.UserService;

// This is another Testing Evironment
// which may not require a full context
@WebMvcTest // @AutoConfigureMockMvc
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Test
  void testGetUsers() throws Exception {
    User user1 = new User(1, "John", "johnlau", "john@gmail.com", null, null, null, null);
    User user2 = new User(2, "Mary", "marylau", "mary@gmail.com", null, null, null, null);
    Mockito.when(userService.findUsers()).thenReturn(List.of(user1, user2));

    // ResultActions mvcResult =
    // mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customer2"));

    mockMvc.perform(get("/api/v1/customer2")).andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.data[0].id").value(1))
        .andExpect(jsonPath("$.data[1].id").value(2));
  }

  @Test
  void testEmptyUsers() throws Exception {
    Mockito.when(userService.findUsers()).thenReturn(null);

    // ResultActions mvcResult =
    // mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customer2"));

    mockMvc.perform(get("/api/v1/customer2")).andExpect(status().isBadRequest())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.data[0].id").value(1))
        .andExpect(jsonPath("$.data[1].id").value(2));
  }
}
