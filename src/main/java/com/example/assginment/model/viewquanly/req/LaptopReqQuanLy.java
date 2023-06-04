package com.example.assginment.model.viewquanly.req;

import com.example.assginment.util.LaptopStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LaptopReqQuanLy {
    private String idBrand;
    private String name;
    private LaptopStatus active;
}
