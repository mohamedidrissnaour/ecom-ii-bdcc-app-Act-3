package net.naour.inventoryservice;

import net.naour.inventoryservice.entities.Product;
import net.naour.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Bicycle")
                    .price(3200)
                    .quantity(11)

                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Ciseau")
                    .price(3200)
                    .quantity(11)

                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Telephone")
                    .price(3200)
                    .quantity(11)

                    .build());

            productRepository.findAll().forEach(
                    p -> {
                        System.out.println(p.toString());
                    }

            );
        };
    }
}
