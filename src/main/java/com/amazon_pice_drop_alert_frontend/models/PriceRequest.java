package com.amazon_pice_drop_alert_frontend.models;

public class PriceRequest {

    private String url;
    private Country countryType;

    public PriceRequest(String url, Country countryType) {
        this.url = url;
        this.countryType = countryType;
    }

    public PriceRequest() {
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
