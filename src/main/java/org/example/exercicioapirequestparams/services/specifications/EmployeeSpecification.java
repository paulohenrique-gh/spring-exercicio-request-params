package org.example.exercicioapirequestparams.services.specifications;

import org.example.exercicioapirequestparams.model.Employee;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class EmployeeSpecification {
    public static Specification<Employee> hasFirstName(String firstName) {
        return (root, query, criteriaBuilder) -> {
            if (firstName == null) return null;

            return criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + firstName.toLowerCase() + "%");
        };
    }

    public static Specification<Employee> hasDepartment(String department) {
        return (root, query, criteriaBuilder) -> {
            if (department == null) return null;

            return criteriaBuilder.like(criteriaBuilder.lower(root.get("department")), "%" + department.toLowerCase() + "%");
        };
    }

    public static Specification<Employee> hasMinSalary(Double minSalary) {
        return (root, query, criteriaBuilder) -> {
            if (minSalary == null) return null;

            return criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), minSalary);
        };
    }

    public static Specification<Employee> wasHiredInDateRange(LocalDate hiredAfter, LocalDate hiredBefore) {
        return (root, query, criteriaBuilder) -> {
            if (hiredAfter == null && hiredBefore == null) return null;

            if (hiredAfter != null && hiredBefore != null) {
                return criteriaBuilder.between(root.get("hiredDate"), hiredAfter, hiredBefore);
            } else if (hiredAfter != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("hiredDate"), hiredAfter);
            } else {
                return criteriaBuilder.lessThanOrEqualTo(root.get("hiredDate"), hiredBefore);
            }
        };
    }

    public static Specification<Employee> isActive(Boolean isActive) {
        return (root, query, criteriaBuilder) -> {
            if (isActive == null) return null;

            return criteriaBuilder.equal(root.get("isActive"), isActive);
        };
    }
}
