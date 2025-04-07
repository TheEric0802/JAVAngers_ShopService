package org.example;

import java.math.BigDecimal;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();

        productRepo.addProduct("1", "Product 1", new BigDecimal("10.99"));
        productRepo.addProduct("2", "Product 2", new BigDecimal("20.99"));
        productRepo.addProduct("3", "Product 3", new BigDecimal("30.99"));

        System.out.println(productRepo.getProducts());
        System.out.println(productRepo.getProduct("1"));

        productRepo.removeProduct("1");
        System.out.println(productRepo.getProducts());


        OrderRepo orderRepo = new OrderMapRepo();

        orderRepo.addOrder("1", Map.of(productRepo.getProduct("2"), 1, productRepo.getProduct("3"), 2));
        orderRepo.addOrder("2", Map.of(productRepo.getProduct("2"), 3, productRepo.getProduct("3"), 4));
        orderRepo.addOrder("3", Map.of(productRepo.getProduct("2"), 10));

        System.out.println(orderRepo.getOrders());
        System.out.println(orderRepo.getOrder("1"));

        orderRepo.removeOrder("1");
        System.out.println(orderRepo.getOrders());

        ShopService shopService = new ShopService(productRepo, orderRepo);
        shopService.createOrder(Map.of("2", 3, "3", 5));

        System.out.println(orderRepo.getOrders());
        System.out.println(orderRepo.getTotalPrice("3"));

    }
}