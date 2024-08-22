package org.example.exercicioapirequestparams.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.exercicioapirequestparams.model.Employee;
import org.example.exercicioapirequestparams.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) LocalDate hiredAfter,
            @RequestParam(required = false) LocalDate hiredBefore,
            @RequestParam(required = false) Boolean active
    ) {
        return ResponseEntity.ok(employeeService.findEmployees(
                firstName, department, minSalary, hiredAfter, hiredBefore, active
        ));
    }

}
