package com.example.assginment.model.viewquanly.res;

import com.example.assginment.entity.Brand;
import com.example.assginment.entity.Laptop;
import com.example.assginment.util.LaptopStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(types = {Laptop.class, Brand.class})
public interface LaptopRes {
    @Value("#{target.id}")
    String getId();
    @Value("#{target.code}")
    String getLaptopCode();
    @Value("#{target.names}")
    String getLaptopName();
    @Value("#{target.price}")

    BigDecimal getPrice();
    @Value("#{target.brandName}")
    String getBrandName();
    @Value("#{target.status}")
    LaptopStatus getStatus();
    @Value("#{target.image}")
    String getImages();
}
