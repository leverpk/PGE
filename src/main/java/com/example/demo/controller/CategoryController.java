package com.example.demo.controller;

import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("{name}")
    public String getCategories(Model model, @PathVariable String name) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("category", categoryService.getByName(name));
        model.addAttribute("name", name);
        if (name.equals("drużyny")){
            return "teams";
        } else return "table";
    }



}
