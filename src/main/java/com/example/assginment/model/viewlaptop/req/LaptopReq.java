package com.example.assginment.model.viewlaptop.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LaptopReq {
    private String idBrand;
    private String name;

    private BigDecimal priceMin;

    private BigDecimal priceMax;

    private String columSort;

    private boolean asc;
}
