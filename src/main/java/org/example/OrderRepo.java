package org.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OrderRepo {

    void addOrder(Order order);

    void addOrder(String orderId, Map<Product, Integer> products);

    List<Order> getOrders();

    Order getOrder(String orderId);

    void removeOrder(String orderId);

    BigDecimal getTotalPrice(String orderId);
}
