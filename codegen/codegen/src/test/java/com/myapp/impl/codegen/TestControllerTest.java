package com.myapp.impl.codegen;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.impl.codegen.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class TestControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldReturn200WithOneEmployeeGetAllEmployees() throws Exception {

        MvcResult result = mockMvc.perform(get("/employees")).andExpect(status().isOk()).andReturn();

        Employee[] employees = objectMapper.readValue(result.getResponse().getContentAsString(), Employee[].class);
        assertThat(employees.length).isEqualTo(1);
        assertThat(employees[0]).isEqualTo(new Employee().id(1).firstName("praj").lastName("s"));
    }

    @Test
    public void shouldReturnCreatedForPOSTCallOnEmployee() throws Exception {
        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON)
                .content("{"
                        + "\"id\": 1,"
                        + "\"firstName\": \"string1\","
                        + "\"lastName\": \"string2\""
                        + "}")).andExpect(status().isCreated());
    }

}