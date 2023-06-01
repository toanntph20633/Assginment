package com.example.assginment.service.viewbanhang;

import com.example.assginment.entity.Laptop;
import com.example.assginment.model.viewlaptop.req.LaptopReq;
import com.example.assginment.model.viewlaptop.res.BrandRes;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LaptopService {
    Page<Laptop> search(LaptopReq req,int page);

    Laptop detailLaptop(String id);
    List<BrandRes> getListBrand();
}
