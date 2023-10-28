package com.shop.storeApp.entity;

import javax.persistence.*;
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private int productPrice;
    private String description;


   /*
    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customers customers;
    */
    public Products() {
        super();
    }

    public Products(Integer productId, String productName, int productPrice, String discription) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = discription;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
