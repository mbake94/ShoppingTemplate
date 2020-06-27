package com.example.demo;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/all")
    public String getAllProducts(Model model){
        ArrayList<Product> listOfProducts = new ArrayList<>();

        model.addAttribute("products", listOfProducts);
        return "products_all";
    }
}
