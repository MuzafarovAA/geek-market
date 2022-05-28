package com.geekbrains.geekmarketwinter.services;

import com.geekbrains.geekmarketwinter.entites.ProductImage;
import com.geekbrains.geekmarketwinter.repositories.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService {
    private ProductImageRepository productImageRepository;

    @Autowired
    public void setProductImageRepository(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    public void saveProductImagePath(ProductImage productImage) {
        productImageRepository.save(productImage);
    }
}
