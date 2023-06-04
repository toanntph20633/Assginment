package com.example.assginment.service.viewadmin;

import com.example.assginment.entity.Laptop;
import com.example.assginment.model.viewquanly.req.LaptopReqQuanLy;
import com.example.assginment.model.viewquanly.res.LaptopRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuanLyLaptopService {
    Page<LaptopRes> search(Pageable pageable, LaptopReqQuanLy req);
    void save(Laptop laptop);
    Laptop detail(String id);

    void update(String id,Laptop laptop);

    void delete(String id);

}
