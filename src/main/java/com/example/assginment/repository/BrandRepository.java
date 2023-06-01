package com.example.assginment.repository;

import com.example.assginment.entity.Brand;
import com.example.assginment.model.viewlaptop.res.BrandRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BrandRepository extends JpaRepository<Brand,String> {
    @Query(value = "select o.id,o.brandName from brand  o where o.status <> 2")
    List<BrandRes> getBrands();
}
