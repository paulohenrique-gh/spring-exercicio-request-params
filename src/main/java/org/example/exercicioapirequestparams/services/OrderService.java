package org.example.exercicioapirequestparams.services;

import lombok.RequiredArgsConstructor;
import org.example.exercicioapirequestparams.model.Order;
import org.example.exercicioapirequestparams.repositories.OrderRepository;
import org.example.exercicioapirequestparams.services.specifications.OrderSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> findOrders(Long orderNumber,
            String customerName,
            String status,
            Integer minAmount,
            Integer maxAmount,
            LocalDate startDate,
            LocalDate endDate) {
        Specification<Order> spec = Specification
                .where(OrderSpecification.hasOrderNumber(orderNumber))
                .and(OrderSpecification.hasCustomerName(customerName))
                .and(OrderSpecification.hasStatus(status))
                .and(OrderSpecification.hasAmountInRange(minAmount, maxAmount))
                .and(OrderSpecification.hasDateRange(startDate, endDate));

        return orderRepository.findAll(spec);
    }
}
