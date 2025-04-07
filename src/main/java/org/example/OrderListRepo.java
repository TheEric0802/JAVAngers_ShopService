package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    public void addOrder(String orderId, Map<Product, Integer> products) {
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

    public BigDecimal getTotalPrice(String orderId) {
        Order order = getOrder(orderId);
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Map.Entry<Product, Integer> entry : order.products().entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            totalPrice = totalPrice.add(product.price().multiply(new BigDecimal(quantity)));
        }
        return totalPrice;
    }
}
