package pl.dkulpa.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.dkulpa.ecommerce.catalog.ProductCatalog;


import javax.swing.*;

@SpringBootApplication
public class App {
    public static void main(String[] args){
        System.out.println("Here we go!");
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createMyCatalog(){
        var catalog = new ProductCatalog();
        catalog.addProduct("Lego set 8883", "Nice one");
        catalog.addProduct("Cobi blocks", "Nice one");

        return catalog;
    }
}
