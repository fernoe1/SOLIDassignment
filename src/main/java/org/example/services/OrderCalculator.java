package org.example.services;

import org.example.models.Order;
import org.example.models.Product;
import org.example.services.interfaces.IOrderCalculator;

public class OrderCalculator implements IOrderCalculator {
    @Override
    public double calculateTotal(Order order) {
        double total = 0;
        for (Product product : order.getProductList()) {
            total += product.getPrice();
        }
        return total;
    }
}
