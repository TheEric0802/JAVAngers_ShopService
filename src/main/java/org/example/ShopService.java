package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ShopService {

    private ProductRepo productRepo;
    private OrderListRepo orderListRepo;

    public ShopService(ProductRepo productRepo, OrderListRepo orderListRepo) {
        this.productRepo = productRepo;
        this.orderListRepo = orderListRepo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShopService that = (ShopService) o;
        return Objects.equals(productRepo, that.productRepo) && Objects.equals(orderListRepo, that.orderListRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepo, orderListRepo);
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "productRepo=" + productRepo +
                ", orderListRepo=" + orderListRepo +
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
            orderListRepo.addOrder(orderId, orderedProducts);
        }
    }
}
