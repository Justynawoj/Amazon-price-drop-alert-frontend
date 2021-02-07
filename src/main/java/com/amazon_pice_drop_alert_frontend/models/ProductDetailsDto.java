package com.amazon_pice_drop_alert_frontend.models;

public class ProductDetailsDto {

    private String asin;
    private String createdAt;
    private String currencySymbol;
    private String title;
    private PriceDetailsDto currentPriceAmazon;
    private PriceDetailsDto highestPriceAmazon;
    private PriceDetailsDto lowestPricingAmazon;
    private PriceDetailsDto currentPriceThirdPart;
    private PriceDetailsDto highestPriceThirdPart;
    private PriceDetailsDto lowestPricingThirdPart;

    public ProductDetailsDto(String asin, String createdAt, String currencySymbol, String title,
                             PriceDetailsDto currentPriceAmazon,
                             PriceDetailsDto highestPriceAmazon,
                             PriceDetailsDto lowestPricingAmazon,
                             PriceDetailsDto currentPriceThirdPart,
                             PriceDetailsDto highestPriceThirdPart,
                             PriceDetailsDto lowestPricingThirdPart) {
        this.asin = asin;
        this.createdAt = createdAt;
        this.currencySymbol = currencySymbol;
        this.title = title;
        this.currentPriceAmazon = currentPriceAmazon;
        this.highestPriceAmazon = highestPriceAmazon;
        this.lowestPricingAmazon = lowestPricingAmazon;
        this.currentPriceThirdPart = currentPriceThirdPart;
        this.highestPriceThirdPart = highestPriceThirdPart;
        this.lowestPricingThirdPart = lowestPricingThirdPart;
    }

    public ProductDetailsDto() {
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

    public String getTitle() {
        return title;
    }

    public PriceDetailsDto getCurrentPriceAmazon() {
        return currentPriceAmazon;
    }

    public PriceDetailsDto getHighestPriceAmazon() {
        return highestPriceAmazon;
    }

    public PriceDetailsDto getLowestPricingAmazon() {
        return lowestPricingAmazon;
    }

    public PriceDetailsDto getCurrentPriceThirdPart() {
        return currentPriceThirdPart;
    }

    public PriceDetailsDto getHighestPriceThirdPart() {
        return highestPriceThirdPart;
    }

    public PriceDetailsDto getLowestPricingThirdPart() {
        return lowestPricingThirdPart;
    }
}
