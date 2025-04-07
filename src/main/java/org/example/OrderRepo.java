package org.example;

import java.util.List;

public interface OrderRepo {

    void addOrder(Order order);

    void addOrder(String orderId, List<Product> products);

    List<Order> getOrders();

    Order getOrder(String orderId);

    void removeOrder(String orderId);
}
