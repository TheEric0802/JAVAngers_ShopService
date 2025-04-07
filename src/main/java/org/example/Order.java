package org.example;

import java.math.BigDecimal;
import java.util.Map;

public record Order(String id, Map<Product, Integer> products) {

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            totalPrice = totalPrice.add(product.price().multiply(new BigDecimal(quantity)));
        }
        return totalPrice;
    }
}
