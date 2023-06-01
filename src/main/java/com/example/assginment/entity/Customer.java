package com.example.assginment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;
    @Column(name = "cus_name")
    @Nationalized
    private String cusName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "sex")
    private boolean sex;
    @Column(name = "age")
    private int age;
    @Column(name = "cus_address")
    private String address;
    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private Set<Account> accounts;
    @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY)
    private Set<Bill> bills;

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", cusName='" + cusName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
