package org.example.models;

public class Product {
    private String productName;
    private double price;
    private int stockQuantity;

    public Product() {

    }

    public Product(String productName, double price, int stockQuantity) {
        setProductName(productName);
        setPrice(price);
        setStockQuantity(stockQuantity);
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
