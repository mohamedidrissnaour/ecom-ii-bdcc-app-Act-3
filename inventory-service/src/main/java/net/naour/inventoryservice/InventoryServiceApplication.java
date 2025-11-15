package net.naour.inventoryservice;

import net.naour.inventoryservice.entities.Product;
import net.naour.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class InventoryServideApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServideApplication.class, args);
    }

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
                    p-> {
                        System.out.println(p.toString());
                    }

            );
        };
    }

}
