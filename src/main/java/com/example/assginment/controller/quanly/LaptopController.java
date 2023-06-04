package com.example.assginment.controller.quanly;

import com.example.assginment.entity.Laptop;
import com.example.assginment.model.viewquanly.req.LaptopReqQuanLy;
import com.example.assginment.model.viewquanly.res.LaptopRes;
import com.example.assginment.service.viewadmin.QuanLyLaptopService;
import com.example.assginment.service.viewbanhang.LaptopServices;
import com.example.assginment.util.FileUploadUtil;
import com.example.assginment.util.LaptopStatus;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin/laptop-manager")
public class LaptopController {
    @Autowired
    private QuanLyLaptopService quanLyLaptopService;

    @Autowired
    private LaptopServices laptopServices;
    private static final String UPLOAD_DIR = "uploads";

    @GetMapping("list")
    public String view(
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "idBrand", defaultValue = "") String idBrand,
            @RequestParam(value = "active", defaultValue = "0") int active,
            @RequestParam(value = "page", defaultValue = "1") int page,
            Model model) {
        LaptopReqQuanLy laptopReqQuanLy = LaptopReqQuanLy.builder()
                .name(name.equals("") ? null : name)
                .idBrand(idBrand.equals("") ? null : idBrand)
                .active(LaptopStatus.valueOf(active))
                .build();
        Page<LaptopRes> laptopResPage = quanLyLaptopService.search(PageRequest.of(page - 1, 10), laptopReqQuanLy);
        System.out.println(laptopResPage.toList());
        model.addAttribute("listLaptop", laptopResPage.toList());
        model.addAttribute("pageSize", laptopResPage.getTotalPages());
        return "page/quan-ly-laptop";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        Laptop laptop = new Laptop();
        model.addAttribute("laptop", laptop);
        model.addAttribute("listBrand", laptopServices.getListBrand());
        return "page/edit-laptop";
    }

    @PostMapping("save-laptop")
    public String viewAdd(@RequestParam(value = "id", defaultValue = "") String id,
                          @RequestParam("file") MultipartFile file,
                          @Valid @ModelAttribute("laptop") Laptop laptop, BindingResult bindingResult,
                          Model model) throws IOException {
//        if (bindingResult.hasErrors()) {
//            return "page/edit-laptop";
//        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        String uploadDir = "user-photos/" + new Date().getTime();

        FileUploadUtil.saveFile(uploadDir, fileName, file);
       return "page/edit-laptop";
    }

    @GetMapping("view-edit")
    public String viewAdd(@RequestParam(value = "id", defaultValue = "") String id, Model model) {
        Laptop laptop = quanLyLaptopService.detail(id);
        model.addAttribute("laptop", laptop);
        model.addAttribute("listBrand", laptopServices.getListBrand());
        return "page/edit-laptop";
    }
    @GetMapping("delete")
    public String delete(@RequestParam(value = "id", defaultValue = "") String id, Model model) {
        quanLyLaptopService.delete(id);
        return "redirect:/admin/laptop-manager/list";
    }
}
