package com.example.assginment.service.viewadmin.Impl;

import com.example.assginment.entity.Laptop;
import com.example.assginment.model.viewquanly.req.LaptopReqQuanLy;
import com.example.assginment.model.viewquanly.res.LaptopRes;
import com.example.assginment.repository.LaptopRepository;
import com.example.assginment.service.viewadmin.QuanLyLaptopService;
import com.example.assginment.util.LaptopStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminLaptopServiceImpl implements QuanLyLaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public Page<LaptopRes> search(Pageable pageable, LaptopReqQuanLy req) {
        return laptopRepository.searchQuanLyLaptop(pageable, req);
    }

    @Override
    public void save(Laptop laptop) {

    }

    @Override
    public Laptop detail(String id) {
        Laptop laptop = laptopRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy Laptop"));
        return laptop;
    }

    @Override
    public void update(String id, Laptop laptop) {

    }

    @Override
    public void delete(String id) {
        Laptop laptop = laptopRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy Laptop"));
        laptop.setStatus(LaptopStatus.DELETED);
        laptop.setDescription("dsfsa");
        laptopRepository.save(laptop);
    }
}
