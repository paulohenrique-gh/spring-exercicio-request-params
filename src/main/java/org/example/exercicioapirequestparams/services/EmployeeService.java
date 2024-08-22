package org.example.exercicioapirequestparams.services;

import lombok.RequiredArgsConstructor;
import org.example.exercicioapirequestparams.model.Employee;
import org.example.exercicioapirequestparams.repositories.EmployeeRepository;
import org.example.exercicioapirequestparams.services.specifications.EmployeeSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(String firstName, String department, Double minSalary, LocalDate hiredAfter, LocalDate hiredBefore, Boolean active) {
        Specification<Employee> spec = Specification
                .where(EmployeeSpecification.hasFirstName(firstName))
                .and(EmployeeSpecification.hasDepartment(department))
                .and(EmployeeSpecification.hasMinSalary(minSalary))
                .and(EmployeeSpecification.wasHiredInDateRange(hiredAfter, hiredBefore))
                .and(EmployeeSpecification.isActive(active));

        return employeeRepository.findAll(spec);
    }
}
