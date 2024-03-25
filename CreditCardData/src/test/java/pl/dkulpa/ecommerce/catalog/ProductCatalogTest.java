package pl.dkulpa.ecommerce.catalog;

import org.junit.jupiter.api.Test;
import pl.dkulpa.ecommerce.catalog.Product;
import pl.dkulpa.ecommerce.catalog.ProductCatalog;

import static org.assertj.core.api.Assertions.*;


import java.math.BigDecimal;
import java.util.List;


public class ProductCatalogTest {

    @Test
    void itListProduct(){
        ProductCatalog catalog = new ProductCatalog();

        List<Product> products = catalog.allProducts();

        assert products.isEmpty();
    }
    @Test
    void itAllowsToAddProduct(){
        ProductCatalog catalog = new ProductCatalog();

        catalog.addProduct("Lego set 8883", "Nice one");
        List<Product> products = catalog.allProducts();

        assertThat(products)
                .hasSize(1);
    }
    @Test
    void itAllowsToLoadProductDetails(){
        ProductCatalog catalog = new ProductCatalog();
        String id= catalog.addProduct("Lego set 8883", "Nice one");

        Product loaded = catalog.getProducts(id);

        assertThat(id).isEqualTo(loaded.getId());
    }
    @Test
    void itAllowsToChangePriceForProduct(){
        ProductCatalog catalog = new ProductCatalog();
        String id= catalog.addProduct("Lego set 8883", "Nice one");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));
        Product loaded = catalog.getProducts(id);
        assertThat(BigDecimal.valueOf(10.10))
                .isEqualTo(loaded.getPrice());

    }
}
