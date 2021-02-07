package com.amazon_pice_drop_alert_frontend.models;

public class AlertRequest {

    private String url;
    private Country country;
    private String requestedPrice;
    private String email;

    public AlertRequest() {
    }

    public AlertRequest(String url, Country country, String requestedPrice, String email) {
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
}
