package com.example.assginment.controller.banhang;

import com.example.assginment.entity.Laptop;
import com.example.assginment.model.viewlaptop.req.LaptopReq;
import com.example.assginment.service.viewbanhang.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping("view-laptop")
public class ViewLaptopController {
    @Autowired
    private LaptopService laptopService;
    @GetMapping("list")
    public String search(@RequestParam(value = "name", defaultValue = "") String name,
                         @RequestParam(value = "idBrand", defaultValue = "") String idBrand,
                         @RequestParam(value = "columSort", defaultValue = "laptopName") String columSort,
                         @RequestParam(value = "priceMin", defaultValue = "") String priceMin,
                         @RequestParam(value = "priceMax", defaultValue = "") String priceMax,
                         @RequestParam(value = "page", defaultValue = "1") int page,
                         @RequestParam(value = "asc", defaultValue = "") String asc, Model model) {
        LaptopReq req = LaptopReq.builder()
                .idBrand(idBrand.equals("") ? null : idBrand)
                .name(name.equals("") ? null : name)
                .priceMin(priceMin.equals("") ? null : new BigDecimal(priceMin))
                .priceMax(priceMax.equals("") ? null : new BigDecimal(priceMax))
                .columSort(columSort)
                .asc(asc.equals(""))
                .build();
        Page<Laptop> laptops = laptopService.search(req,page-1);
        System.out.println(laptopService.getListBrand());
        model.addAttribute("listLaptop",laptops.toList());
        model.addAttribute("listBrand",laptopService.getListBrand());
        model.addAttribute("pageSize",laptops.getTotalPages());
        return "page/view-laptop";
    }
}
