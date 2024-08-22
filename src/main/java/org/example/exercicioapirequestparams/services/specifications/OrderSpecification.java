package org.example.exercicioapirequestparams.services.specifications;

import org.example.exercicioapirequestparams.model.Order;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class OrderSpecification {
    public static Specification<Order> hasOrderNumber(Long orderNumber) {
        return (root, query, criteriaBuilder) -> {
            if (orderNumber == null) return null;

            return criteriaBuilder.equal(root.get("orderNumber"), orderNumber);
        };
    }

    public static Specification<Order> hasCustomerName(String customerName) {
        return (root, query, criteriaBuilder) -> {
            if (customerName == null) return null;

            return criteriaBuilder.like(criteriaBuilder.lower(root.get("")), "%" + customerName.toLowerCase() + "%");
        };
    }

    public static Specification<Order> hasStatus(String status) {
        return (root, query, criteriaBuilder) -> {
            if (status == null) return null;

            return criteriaBuilder.like(criteriaBuilder.lower(root.get("status")), "%" + status.toLowerCase() + "%");
        };
    }

    public static Specification<Order> hasAmountInRange(Integer minAmount, Integer maxAmount) {
        return (root, query, criteriaBuilder) -> {
            if (minAmount == null && maxAmount == null) return null;

            if (minAmount != null && maxAmount != null) {
                return criteriaBuilder.between(root.get("amount"), minAmount, maxAmount);
            } else if (minAmount != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("amount"), minAmount);
            } else {
                return criteriaBuilder.lessThanOrEqualTo(root.get("amount"), maxAmount);
            }
        };
    }

    public static Specification<Order> hasDateRange(LocalDate startDate, LocalDate endDate) {
        return (root, query, criteriaBuilder) -> {
            if (startDate == null && endDate == null) return null;

            if (startDate != null && endDate != null) {
                return criteriaBuilder.between(root.get("date"), startDate, endDate);
            } else if (startDate != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("date"), startDate);
            } else {
                return criteriaBuilder.lessThanOrEqualTo(root.get("date"), endDate);
            }
        };
    }

}
