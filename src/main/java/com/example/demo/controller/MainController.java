package com.example.demo.controller;

import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("categories", categoryService.findAllCategories());
        return "index";
    }

}
