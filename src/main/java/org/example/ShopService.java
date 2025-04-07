package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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

    public void createOrder(List<String> productIds) {
        List<Product> orderedProducts = new ArrayList<>();
        boolean allProductsExist = true;

        for (String productId : productIds) {
            Product product = productRepo.getProduct(productId);
            if (product != null) {
                orderedProducts.add(product);
            } else {
                System.out.println("Product with ID " + productId + " does not exist.");
                allProductsExist = false;
            }
        }

        if (allProductsExist) {
            String orderId = UUID.randomUUID().toString();
            orderRepo.addOrder(orderId, orderedProducts);
        }
    }
}
