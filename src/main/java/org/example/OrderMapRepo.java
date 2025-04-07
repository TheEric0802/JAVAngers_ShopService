package org.example;

import java.util.*;

public class OrderMapRepo implements OrderRepo {

    private Map<String, Order> orders = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderMapRepo that = (OrderMapRepo) o;
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }

    @Override
    public String toString() {
        return "OrderMapRepo{" +
                "orders=" + orders +
                '}';
    }

    public void addOrder(Order order) {
        orders.put(order.id(), order);
    }

    public void addOrder(String orderId, List<Product> products) {
        this.addOrder(new Order(orderId, products));
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

    public Order getOrder(String orderId) {
        Order order = orders.get(orderId);
        return order;
    }

    public void removeOrder(String orderId) {
        orders.remove(orderId);
    }
}
