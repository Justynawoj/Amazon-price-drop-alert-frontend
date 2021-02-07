package com.amazon_pice_drop_alert_frontend.models;

public class ProductInfo {

    private String title;
    private String asin;
    private String createdAt;
    private String currencySymbol;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getTitle() {
        return title;
    }

    public String getAsin() {
        return asin;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }
}
