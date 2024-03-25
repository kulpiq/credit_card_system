package pl.dkulpa.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {

    private ArrayList<Product> products;

    public ProductCatalog() {
        products = new ArrayList<>();
    }

    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);

    }

    public String addProduct(String name, String description) {
        UUID id = UUID.randomUUID();
        Product newProduct = new Product(id, name, description);

        products.add(newProduct);

        return newProduct.getId();
    }

    public Product getProducts(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void changePrice(String id, BigDecimal newPrice){
        var loadedProduct = getProducts(id);
        loadedProduct.setPrice(newPrice);

    }
}
