package net.naour.customerservice;

import net.naour.customerservice.entities.Customer;
import net.naour.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean

    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("Mohamed")
                    .email("mohamed@gmail.com")
                    .build());

            customerRepository.save(Customer.builder()
                    .name("Ali")
                    .email("ali@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Walid")
                    .email("walid@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Abdo")
                    .email("abdo@gmail.com")
                    .build());
            customerRepository.findAll().forEach(c->{
                System.out.println("***********************");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("***********************");
            });


        };

    }

}
