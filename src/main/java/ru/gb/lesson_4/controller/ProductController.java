package ru.gb.lesson_4.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.lesson_4.model.Product;
import ru.gb.lesson_4.repository.ProductProvider;
import ru.gb.lesson_4.service.ProductService;

import javax.annotation.PostConstruct;
import java.beans.ConstructorProperties;


@Controller
@RequiredArgsConstructor
public class ProductController {

    boolean start = true;
    private final ProductProvider productProvider;
    private final ProductService productService;
    Integer editId;


    @GetMapping("/all")
    public String getAllMessages(Model model) {
        model.addAttribute("findProduct", new Product());
        if (start) {
            model.addAttribute("products", productProvider.getProduct());
            start = false;
        }
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }


    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "create-product";
    }

    @PostMapping("/create")
    public String processForm(Product product) {
        productService.save(product);
        return "redirect:/all";
    }

    @GetMapping("/{id}")
    public String showChangeForm(Model model, @PathVariable Integer id,
                                 @RequestParam(name="delete", defaultValue = "false", required = false)
                                         Boolean isDelete) {
        if (!isDelete) {
            editId = id;
            model.addAttribute("product", new Product());
            return "edit";
        } else {
            productService.deleteById(id);
            return "redirect:/all";
        }
    }

    @PostMapping("/edit")
    public String changeForm(Product product) {
        productService.edit(product, editId);
        return "redirect:/all";
    }

    @GetMapping("/delete")
    public String show(Model model) {
        model.addAttribute("product", new Product());
        return "delete";
    }

    @PostMapping("/search")
    public String findById(Product product, Model model) {
        Product findProduct;
        findProduct = productService.findById(product);
        model.addAttribute("findProduct", findProduct);
        return "search";
    }
}
