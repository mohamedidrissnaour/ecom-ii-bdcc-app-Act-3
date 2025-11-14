package net.naour.billingservice.web;

import net.naour.billingservice.entities.Bill;
import net.naour.billingservice.feign.CustomerRestClient;
import net.naour.billingservice.feign.ProductRestClient;
import net.naour.billingservice.repository.BillRepository;
import net.naour.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository  billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;


    @GetMapping(path = "/bills/{id}")
    private Bill getBill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getId()));
        });
        return bill;
    }


}
