package org.example;

import java.util.*;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShopService that = (ShopService) o;
        return Objects.equals(productRepo, that.productRepo) && Objects.equals(orderRepo, that.orderRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepo, orderRepo);
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderRepo=" + orderRepo +
                '}';
    }

    public void createOrder(Map<String, Integer> productIdsAndQuantity) {
        Map<Product, Integer> orderedProductsAndQuantity = new HashMap<>();
        boolean allProductsExist = true;

        for (String productId : productIdsAndQuantity.keySet()) {
            Product product = productRepo.getProduct(productId);
            if (product != null) {
                orderedProductsAndQuantity.put(product, productIdsAndQuantity.get(productId));
            } else {
                System.out.println("Product with ID " + productId + " does not exist.");
                allProductsExist = false;
            }
        }

        if (allProductsExist) {
            String orderId = UUID.randomUUID().toString();
            orderRepo.addOrder(orderId, orderedProductsAndQuantity);
        }
    }
}
