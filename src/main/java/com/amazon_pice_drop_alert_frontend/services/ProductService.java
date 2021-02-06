package com.amazon_pice_drop_alert_frontend.services;

import com.amazon_pice_drop_alert_frontend.models.ProductDetailsDto;
import com.amazon_pice_drop_alert_frontend.views.MainView;
import org.springframework.web.client.RestTemplate;

public class ProductService {

    private static final String PRODUCT_URL = MainView.BACKEND_URL + "/v1/price";
    private static ProductService productService;
    private RestTemplate restTemplate = new RestTemplate();

    public static ProductService getInstance(){
        if (productService == null){
            productService = new ProductService();
        }
        return productService;
    }

    public ProductDetailsDto getProductDetails(String amazonUrl, String country){

        String url = PRODUCT_URL + "?url=" + amazonUrl + "&country=" + country;
        return restTemplate.getForObject(url, ProductDetailsDto.class);
    }

}
