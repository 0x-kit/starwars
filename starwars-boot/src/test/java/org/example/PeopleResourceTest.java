package org.example;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PeopleResourceTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void searchPeople() throws Exception {
    mockMvc.perform(get("/swapi-proxy/person-info")
        .param("name", "Luke"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.*", hasSize(1)))
        .andExpect(jsonPath("$[0].name").value("Luke Skywalker"));
  }

  @Test
  public void searchPeopleWithNoMandatoryParams() throws Exception {
    mockMvc.perform(get("/swapi-proxy/person-info"))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void searchUnexistingPeople() throws Exception {
    mockMvc.perform(get("/swapi-proxy/person-info")
        .param("name", "Pedro Sanchez"))
        .andExpect(status().isNotFound());
  }
}
