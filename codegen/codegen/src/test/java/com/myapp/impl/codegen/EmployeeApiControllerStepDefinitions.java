package com.myapp.impl.codegen;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.impl.codegen.model.Employee;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@CucumberContextConfiguration
@WebMvcTest
public class EmployeeApiControllerStepDefinitions {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    MvcResult mvcResult;

    Employee[] employees;

    String employeePayload;

//    @Test
//    public void shouldReturn200WithOneEmployeeGetAllEmployees() throws Exception {
//
//        MvcResult result = mockMvc.perform(get("/employees")).andExpect(status().isOk()).andReturn();
//
//        Employee[] employees = objectMapper.readValue(result.getResponse().getContentAsString(), Employee[].class);
//        assertThat(employees.length).isEqualTo(1);
//        assertThat(employees[0]).isEqualTo(new Employee().id(1).firstName("praj").lastName("s"));
//    }
//
//    @Test
//    public void shouldReturnCreatedForPOSTCallOnEmployee() throws Exception {
//        mockMvc.perform(post("/employees").contentType(MediaType.APPLICATION_JSON)
//                .content("{"
//                        + "\"id\": 1,"
//                        + "\"firstName\": \"prajwal\","
//                        + "\"lastName\": \"s\""
//                        + "}")).andExpect(status().isCreated());
//    }

    @Given("The system has employees")
    public void systemHasEmployees() {
        //nothing
    }

    @When("Requested for GET {string}")
    public void requestedForGET(String arg0) throws Exception {
        mvcResult = mockMvc.perform(get(arg0)).andReturn();
        employees = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Employee[].class);
    }

    @Then("Should respond with status {int}")
    public void shouldRespondWithStatus(int arg0) throws Exception {
        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(arg0);
    }

    @Then("Should return {int} employee")
    public void shouldReturnEmployee(int arg0) throws UnsupportedEncodingException, JsonProcessingException {
        assertThat(employees.length).isEqualTo(arg0);
    }

    @And("Should return employee with firstName as {string}")
    public void shouldReturnEmployeeWithFirstNameAs(String arg0) {
        assertThat(employees[0].getFirstName()).isEqualTo(arg0);
    }

    @And("Should return employee with lastName as {string}")
    public void shouldReturnEmployeeWithLastNameAs(String arg0) {
        assertThat(employees[0].getLastName()).isEqualTo(arg0);
    }


    @Given("The employee payload")
    public void theEmployeePayload(String employeePayload) {
        this.employeePayload = employeePayload;
    }

    @When("POST request is sent for {string}")
    public void postRequestIsSentFor(String arg0) throws Exception {
        mvcResult = mockMvc.perform(post(arg0).contentType(MediaType.APPLICATION_JSON).content(employeePayload)).andReturn();
    }

}