package com.example.assginment.repository;

import com.example.assginment.entity.Laptop;
import com.example.assginment.model.viewlaptop.req.LaptopReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,String> {
    @Query(value = """
                select o from laptop o where 
                    (:#{#req.name} is null or o.laptopName like :#{'%'+#req.name+'%'})
                and (:#{#req.idBrand} is null or o.brandId.id = :#{#req.idBrand})
                and ((:#{#req.priceMax} is null or :#{#req.priceMin} is null) or ( o.price between :#{#req.priceMin} and :#{#req.priceMax}))
                and o.status <> 2 and o.brandId.status <> 2
            """)
    Page<Laptop> search(Pageable pageable, LaptopReq req);
}
