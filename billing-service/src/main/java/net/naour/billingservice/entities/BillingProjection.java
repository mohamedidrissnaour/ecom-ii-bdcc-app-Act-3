package net.naour.billingservice.entities;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import net.naour.billingservice.model.Customer;
import net.naour.billingservice.model.Product;
import org.springframework.data.rest.core.config.Projection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Projection(name = "FullBilling" , types = Bill.class)
public interface BillingProjection {
    Long getid();
    Date getbillingDate();
    Long getcustomerId();
}
