package com.amazon_pice_drop_alert_frontend.models;

public class AlertRequestDto {

    private String url;
    private Country country;
    private String requestedPrice;
    private String email;

    public AlertRequestDto() {
    }

    public AlertRequestDto(String url, Country country, String requestedPrice, String email) {
        this.url = url;
        this.country = country;
        this.requestedPrice = requestedPrice;
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public Country getCountry() {
        return country;
    }

    public String getRequestedPrice() {
        return requestedPrice;
    }

    public String getEmail() {
        return email;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setRequestedPrice(String requestedPrice) {
        this.requestedPrice = requestedPrice;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
