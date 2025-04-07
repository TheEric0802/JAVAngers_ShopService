package org.example;

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


        OrderListRepo orderListRepo = new OrderListRepo();

        orderListRepo.addOrder("1", productRepo.getProducts());
        orderListRepo.addOrder("2", productRepo.getProducts());
        orderListRepo.addOrder("3", productRepo.getProducts());

        System.out.println(orderListRepo.getOrders());
        System.out.println(orderListRepo.getOrder("1"));

        orderListRepo.removeOrder("1");
        System.out.println(orderListRepo.getOrders());

    }
}