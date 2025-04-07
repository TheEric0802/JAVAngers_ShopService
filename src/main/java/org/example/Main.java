package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();

        productRepo.addProduct("1", "Product 1");
        productRepo.addProduct("2", "Product 2");
        productRepo.addProduct("3", "Product 3");

        System.out.println(productRepo.getProducts());
        System.out.println(productRepo.getProduct("1"));

        productRepo.removeProduct("1");
        System.out.println(productRepo.getProducts());


        OrderRepo orderRepo = new OrderMapRepo();

        orderRepo.addOrder("1", productRepo.getProducts());
        orderRepo.addOrder("2", productRepo.getProducts());
        orderRepo.addOrder("3", productRepo.getProducts());

        System.out.println(orderRepo.getOrders());
        System.out.println(orderRepo.getOrder("1"));

        orderRepo.removeOrder("1");
        System.out.println(orderRepo.getOrders());

        ShopService shopService = new ShopService(productRepo, orderRepo);
        shopService.createOrder(List.of("2", "3"));

        System.out.println(orderRepo.getOrders());

    }
}