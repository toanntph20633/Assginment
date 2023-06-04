package com.example.assginment.service.viewbanhang.impl;

import com.example.assginment.entity.Laptop;
import com.example.assginment.model.viewlaptop.req.LaptopReq;
import com.example.assginment.model.viewlaptop.res.BrandRes;
import com.example.assginment.repository.BrandRepository;
import com.example.assginment.repository.LaptopRepository;
import com.example.assginment.service.viewbanhang.LaptopServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopServices {
    @Autowired
    private LaptopRepository laptopRepository;
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Page<Laptop> search(LaptopReq req, int page) {
        return laptopRepository.search(PageRequest.of(page, 3, Sort.by(req.isAsc() ? Sort.Direction.ASC : Sort.Direction.DESC, req.getColumSort())), req);
    }

    @Override
    public Laptop detailLaptop(String id) {
        return laptopRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong tim thay id"));
    }

    @Override
    public List<BrandRes> getListBrand() {
        return brandRepository.getBrands();
    }

}
