package com.myapp.impl.codegen;

import com.myapp.impl.codegen.api.EmployeesApi;
import com.myapp.impl.codegen.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController implements EmployeesApi {

    @Override
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(List.of(new Employee().id(1).firstName("praj").lastName("s")));
    }
}
