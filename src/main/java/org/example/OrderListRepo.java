package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderListRepo implements OrderRepo {

    private List<Order> orders = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderListRepo that = (OrderListRepo) o;
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orders=" + orders +
                '}';
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void addOrder(String orderId, List<Product> products) {
        this.addOrder(new Order(orderId, products));
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrder(String orderId) {
        for (Order order : orders) {
            if (order.id().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    public void removeOrder(String orderId) {
        Order order = getOrder(orderId);
        if (order != null) {
            orders.remove(order);
        }
    }
}
