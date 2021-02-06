package com.amazon_pice_drop_alert_frontend.models;

public class PriceDetailsDto {
    private double price;
    private String createdAt;

    public PriceDetailsDto(double price, String createdAt) {
        this.price = price;
        this.createdAt = createdAt;
    }

    public PriceDetailsDto() {
    }

    public double getPrice() {
        return price;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
