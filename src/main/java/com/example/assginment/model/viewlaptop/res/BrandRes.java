package com.example.assginment.model.viewlaptop.res;

import com.example.assginment.entity.Brand;
import lombok.ToString;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "brandRes",types = Brand.class)
public interface BrandRes {
    String getId();
    String getBrandName();
}
