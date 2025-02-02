package org.example.services.interfaces;

import org.example.models.Order;

public interface IOrderCalculator {
    double calculateTotal(Order order);
}
