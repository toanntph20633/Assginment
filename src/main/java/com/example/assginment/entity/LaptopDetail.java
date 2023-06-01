package com.example.assginment.entity;


import com.example.assginment.util.LaptopDetailStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@Entity(name = "laptop_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LaptopDetail {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;
    @Column(name = "laptop_detail_code")
    private String laptopDetailCode;
    @ManyToOne
    @JoinColumn(name = "laptop_id")
    private Laptop laptopId;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private LaptopDetailStatus status;
}
