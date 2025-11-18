package net.naour.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import net.naour.billingservice.model.Product;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter @Setter
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    private int quantity;
    private double unitPrice;
    private String productId;
    @Transient //cette juste attribut dans la classe pas dans la bd
    private Product product;


    public double getAmount() {
        return unitPrice*quantity;
    }
}
