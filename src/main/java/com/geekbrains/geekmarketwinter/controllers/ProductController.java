package com.geekbrains.geekmarketwinter.controllers;

import com.geekbrains.geekmarketwinter.entites.Product;
import com.geekbrains.geekmarketwinter.entites.ProductImage;
import com.geekbrains.geekmarketwinter.services.CategoryService;
import com.geekbrains.geekmarketwinter.services.ProductImageService;
import com.geekbrains.geekmarketwinter.services.ProductService;
import com.geekbrains.geekmarketwinter.services.ImageSaverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;
    private ImageSaverService imageSaverService;
    private ProductImageService productImageService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setImageSaverService(ImageSaverService imageSaverService) {
        this.imageSaverService = imageSaverService;
    }

    @Autowired
    public void setProductImageService(ProductImageService productImageService) {
        this.productImageService = productImageService;
    }

    @GetMapping("/add")
    public String showProductForm(Model model) {
        Product product = new Product();
        product.setId(0L);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product-form";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute(value="product") Product product, @RequestParam("file") MultipartFile file) {
        productService.saveProduct(product);
        if (!file.isEmpty()) {
            String path = imageSaverService.saveFile(file);
            ProductImage productImage = new ProductImage();
            productImage.setPath(path);
            productImage.setProduct(product);
            product.addImage(productImage);
            productImageService.saveProductImagePath(productImage);
        }
        return "redirect:/shop";
    }
}
