package com.example.assginment.entity;

import com.example.assginment.util.LaptopStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity(name = "laptop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Laptop {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @NotNull(message = "Không để trống mã")
    @NotBlank(message = "Không để trống mã")
    @Column(name = "laptop_code")
    private String laptopCode;
    @NotNull(message = "Không để trống tên")
    @NotBlank(message = "Không để trống tên")
    @Column(name = "laptop_name")
    private String laptopName;
    @Column(name = "price")
    @NotNull(message = "Không để trống giá")
    @Min(value = 0, message = "Giá phải là số nguyên dương")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    @NotNull(message = "Không để trống loại")
    private Brand brandId;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private LaptopStatus status;
    @NotNull(message = "Không để trống mô tả")
    @NotBlank(message = "Không để trống mô tả")
    @Column(name = "description")
    private String description;
    @Column(name = "images")
    private String images;
//    @OneToMany(mappedBy = "laptopId", fetch = FetchType.LAZY)
//    private Set<LaptopDetail> laptopDetails;

    @Override
    public String toString() {
        return "Laptop{" +
                "id='" + id + '\'' +
                ", laptopCode='" + laptopCode + '\'' +
                ", laptopName='" + laptopName + '\'' +
                ", price='" + price + '\'' +
                ", brandId=" + brandId +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}' + "\n";
    }
}
