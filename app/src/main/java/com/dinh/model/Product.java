package com.dinh.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product  implements Serializable {

    @SerializedName("productId")
    @Expose
    private Integer productId;
    @SerializedName("categoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("productPrice")
    @Expose
    private String productPrice;
    @SerializedName("percentSale")
    @Expose
    private String percentSale;
    @SerializedName("priceSale")
    @Expose
    private String priceSale;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("productImage")
    @Expose
    private String productImage;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("rate")
    @Expose
    private String rate;

    //public boolean selected;

    public Product() {
    }

    public Product(Integer productId, Integer categoryId, String productName, String productPrice, String percentSale, String priceSale, String amount, String description, String productImage, String status, String rate) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.percentSale = percentSale;
        this.priceSale = priceSale;
        this.amount = amount;
        this.description = description;
        this.productImage = productImage;
        this.status = status;
        this.rate = rate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getPercentSale() {
        return percentSale;
    }

    public void setPercentSale(String percentSale) {
        this.percentSale = percentSale;
    }

    public String getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(String priceSale) {
        this.priceSale = priceSale;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

}