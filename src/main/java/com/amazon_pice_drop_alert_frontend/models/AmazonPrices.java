package com.amazon_pice_drop_alert_frontend.models;

public class AmazonPrices {

    private double currentPriceAmazon;
    private String dateCurrentPrice;
    private double highestPriceAmazon;
    private String dateHighestPriceAmazon;
    private double lowestPricingAmazon;
    private String dateLowestPricingAmazon;

    public double getCurrentPriceAmazon() {
        return currentPriceAmazon;
    }

    public void setCurrentPriceAmazon(double currentPriceAmazon) {
        this.currentPriceAmazon = currentPriceAmazon;
    }

    public String getDateCurrentPrice() {
        return dateCurrentPrice;
    }

    public void setDateCurrentPrice(String dateCurrentPrice) {
        this.dateCurrentPrice = dateCurrentPrice;
    }

    public double getHighestPriceAmazon() {
        return highestPriceAmazon;
    }

    public void setHighestPriceAmazon(double highestPriceAmazon) {
        this.highestPriceAmazon = highestPriceAmazon;
    }

    public String getDateHighestPriceAmazon() {
        return dateHighestPriceAmazon;
    }

    public void setDateHighestPriceAmazon(String dateHighestPriceAmazon) {
        this.dateHighestPriceAmazon = dateHighestPriceAmazon;
    }

    public double getLowestPricingAmazon() {
        return lowestPricingAmazon;
    }

    public void setLowestPricingAmazon(double lowestPricingAmazon) {
        this.lowestPricingAmazon = lowestPricingAmazon;
    }

    public String getDateLowestPricingAmazon() {
        return dateLowestPricingAmazon;
    }

    public void setDateLowestPricingAmazon(String dateLowestPricingAmazon) {
        this.dateLowestPricingAmazon = dateLowestPricingAmazon;
    }
}
