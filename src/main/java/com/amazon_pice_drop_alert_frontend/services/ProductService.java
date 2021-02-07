package com.amazon_pice_drop_alert_frontend.services;

import com.amazon_pice_drop_alert_frontend.models.Country;
import com.amazon_pice_drop_alert_frontend.models.ProductDetailsDto;
import com.amazon_pice_drop_alert_frontend.views.MainView;
import org.springframework.web.client.RestTemplate;

public class ProductService {

    private static final String PRODUCT_URL = MainView.BACKEND_URL + "/v1/price";
    private static ProductService productService;
    private RestTemplate restTemplate = new RestTemplate();
    private ProductDetailsDto productDetailsDto = new ProductDetailsDto();

    public static ProductService getInstance(){
        if (productService == null){
            productService = new ProductService();
        }
        return productService;
    }

    public void sendRequestToBackend(String amazonUrl, Country country){

        String url = PRODUCT_URL + "?url=" + amazonUrl + "&country=" + country;
        productDetailsDto = restTemplate.getForObject(url, ProductDetailsDto.class);
    }

    public ProductDetailsDto getProductDetailsDto() {
        return productDetailsDto;
    }
}
