package com.amazon_pice_drop_alert_frontend.models;

public class PriceRequestDto {

    private String url;
    private Country countryType;

    public PriceRequestDto(String url, Country countryType) {
        this.url = url;
        this.countryType = countryType;
    }

    public PriceRequestDto() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Country getCountryType() {
        return countryType;
    }

    public void setCountryType(Country countryType) {
        this.countryType = countryType;
    }

}
