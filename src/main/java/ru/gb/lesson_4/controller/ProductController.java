package ru.gb.lesson_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/product")
    public String ProductJsp(Model model) {
        model.addAttribute("msg", "Product List");
        return "product";
    }
}
