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

    @GetMapping("/{id}")
    public String getCategories(Model model, @PathVariable Long id) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("category", categoryService.getById(id));
        model.addAttribute("categoryId", id);
        return "/product/list";
    }

}
