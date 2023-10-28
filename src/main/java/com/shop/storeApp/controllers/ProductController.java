package com.shop.storeApp.controllers;

import com.shop.storeApp.DTO.ProductDto;
import com.shop.storeApp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/product")
    public ResponseEntity<ProductDto> createProduct (@RequestBody ProductDto productDto){
        ProductDto addProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(addProduct , HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/product/{productId}")
    public ResponseEntity<String> deleteProduct (@PathVariable Integer productId) {
        String deleteProduct = productService.deleteProductById(productId);
       // return new ResponseEntity<>(deleteProduct, HttpStatus.OK);
        return ResponseEntity.ok(deleteProduct);
    }

    @GetMapping(path = "/product/{productId}")
    public ResponseEntity<ProductDto> findProductById (@PathVariable Integer productId) {
        return ResponseEntity.ok(this.productService.getProductById(productId));
    }
}
