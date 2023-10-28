package com.shop.storeApp.services.impl;

import com.shop.storeApp.DTO.ProductDto;
import com.shop.storeApp.entity.Customers;
import com.shop.storeApp.entity.Products;
import com.shop.storeApp.repositories.ProductRepo;
import com.shop.storeApp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductSeviceImpl implements ProductService {
    @Autowired
    public ProductRepo productRepo ;
    /*
    @Autowired
    public CustomerRepo customerRepo;
     */
    public Products dtoToProducts (ProductDto productDto){
        Products product = new Products();

        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        product.setDescription(productDto.getDescription());

        return product;
    }

    public ProductDto productToDto (Products product){
        ProductDto productDTO = new ProductDto();

        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductPrice(product.getProductPrice());
        productDTO.setDescription(product.getDescription());

        return productDTO;
    }


    @Override
    public ProductDto createProduct(ProductDto productDTO) {
        Products product = this.dtoToProducts(productDTO);
        Products createdProduct = this.productRepo.save(product);
        return this.productToDto(createdProduct);
    }

    /*
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Optional <Customers> purchase = this.customerRepo.findById(productDTO.getCustomerId());
        Customers customer = purchase.get();
        Products product = this.dtoToProducts(productDTO);
        product.setCustomers(customer);
        Products createdProduct = this.productRepo.save(product);
        return this.productToDto(createdProduct);
    }
     */

    @Override
    public String deleteProductById(Integer productID) {

        Optional<Products> deleteProduct = this.productRepo.findById(productID);

        if(deleteProduct.isPresent()){
            this.productRepo.deleteById(productID);
            String message = "product is deleted sucessfully";
            return message;
        }
        String message = "product not found";
        return message;
    }

    @Override
    public ProductDto getProductById(Integer productID) {

        Optional<Products> product = this.productRepo.findById(productID);

        return this.productToDto(product.get());

    }

    @Override
    public List<ProductDto> getAllProducts(ProductDto productDto) {

        List<Products> products = this.productRepo.findAll();

        List<ProductDto> allProducts = new ArrayList<>();

        for (Products productObj : products) {
            allProducts.add(productToDto(productObj));
        }
        return allProducts;
    }
}
