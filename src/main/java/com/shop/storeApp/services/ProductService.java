package com.shop.storeApp.services;


import com.shop.storeApp.DTO.ProductDto;

import java.util.List;

public interface ProductService  {

    ProductDto createProduct(ProductDto productDTO);

    String deleteProductById (Integer productID );

    ProductDto getProductById(Integer productID);

    List<ProductDto> getAllProducts (ProductDto productDto);

}
