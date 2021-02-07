package com.amazon_pice_drop_alert_frontend.models;

public class AmazonPrices {

    private Double currentPriceAmazon;
    private String dateCurrentPrice;
    private Double highestPriceAmazon;
    private String dateHighestPriceAmazon;
    private Double lowestPricingAmazon;
    private String dateLowestPricingAmazon;

    public Double getCurrentPriceAmazon() {
        return currentPriceAmazon;
    }

    public void setCurrentPriceAmazon(Double currentPriceAmazon) {
        this.currentPriceAmazon = currentPriceAmazon;
    }

    public String getDateCurrentPrice() {
        return dateCurrentPrice;
    }

    public void setDateCurrentPrice(String dateCurrentPrice) {
        this.dateCurrentPrice = dateCurrentPrice;
    }

    public Double getHighestPriceAmazon() {
        return highestPriceAmazon;
    }

    public void setHighestPriceAmazon(Double highestPriceAmazon) {
        this.highestPriceAmazon = highestPriceAmazon;
    }

    public String getDateHighestPriceAmazon() {
        return dateHighestPriceAmazon;
    }

    public void setDateHighestPriceAmazon(String dateHighestPriceAmazon) {
        this.dateHighestPriceAmazon = dateHighestPriceAmazon;
    }

    public Double getLowestPricingAmazon() {
        return lowestPricingAmazon;
    }

    public void setLowestPricingAmazon(Double lowestPricingAmazon) {
        this.lowestPricingAmazon = lowestPricingAmazon;
    }

    public String getDateLowestPricingAmazon() {
        return dateLowestPricingAmazon;
    }

    public void setDateLowestPricingAmazon(String dateLowestPricingAmazon) {
        this.dateLowestPricingAmazon = dateLowestPricingAmazon;
    }
}
