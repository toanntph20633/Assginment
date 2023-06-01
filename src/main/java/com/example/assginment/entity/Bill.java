package com.example.assginment.entity;

import com.example.assginment.util.BillStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "Bill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;
    @Column(name = "bill_code")
    private String billCode;
    @Column(name = "date_create")
    private LocalDate dateCreate;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "price_sale")
    private BigDecimal priceSale;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customerId;

    @Column(name = "status")
    private BillStatus status;
}
