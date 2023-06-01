package com.example.assginment.entity;

import com.example.assginment.util.StatusAccount;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private StatusAccount statusAccount;
}
