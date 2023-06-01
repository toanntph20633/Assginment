package com.example.assginment.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(HttpServletRequest request,Model model){
        return "page/trang-chu";
    }
    @GetMapping("/laptop")
    public String viewLaptop(Model model){
        return "page/view-laptop";
    }

}
