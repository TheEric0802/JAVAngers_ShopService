package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepo {

    private List<Product> products = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProduct(String id, String name) {
        this.addProduct(new Product(id, name));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(String id) {
        for (Product product : products) {
            if (product.id().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void removeProduct(String id) {
        Product product = getProduct(id);
        if (product != null) {
            products.remove(product);
        }
    }

}
