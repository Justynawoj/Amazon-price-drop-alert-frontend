package com.amazon_pice_drop_alert_frontend.services;

import com.amazon_pice_drop_alert_frontend.models.*;
import com.amazon_pice_drop_alert_frontend.views.MainView;
import org.springframework.web.client.RestTemplate;

public class ProductService {

    private static final String PRODUCT_URL = MainView.BACKEND_URL + "/v1/price";
    private static ProductService productService;
    private RestTemplate restTemplate = new RestTemplate();
    private ProductDetailsDto productDetailsDto = new ProductDetailsDto();

    private ProductInfo productInfo = new ProductInfo();
    private AmazonPrices amazonPrices = new AmazonPrices();
    private ThirdPartPrices thirdPartPrices = new ThirdPartPrices();

    public static ProductService getInstance(){
        if (productService == null){
            productService = new ProductService();
        }
        return productService;
    }

    public void sendRequestToBackend(String amazonUrl, Country country){

        String url = PRODUCT_URL + "?url=" + amazonUrl + "&country=" + country;
        productDetailsDto = restTemplate.getForObject(url, ProductDetailsDto.class);
        mapProductDetailsDto(productDetailsDto);
    }

    public ProductDetailsDto getProductDetailsDto() {
        return productDetailsDto;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public AmazonPrices getAmazonPrices() {
        return amazonPrices;
    }

    public ThirdPartPrices getThirdPartPrices() {
        return thirdPartPrices;
    }

    public void mapProductDetailsDto(ProductDetailsDto productDetailsDto){

        productInfo.setAsin(productDetailsDto.getAsin());
        productInfo.setCreatedAt(productDetailsDto.getCreatedAt());
        productInfo.setCurrencySymbol(productDetailsDto.getCurrencySymbol());
        productInfo.setTitle(productDetailsDto.getTitle());

        amazonPrices.setCurrentPriceAmazon(productDetailsDto.getCurrentPriceAmazon().getPrice());
        amazonPrices.setDateCurrentPrice(productDetailsDto.getCurrentPriceAmazon().getCreatedAt());

        amazonPrices.setHighestPriceAmazon(productDetailsDto.getHighestPriceAmazon().getPrice());
        amazonPrices.setDateHighestPriceAmazon(productDetailsDto.getHighestPriceAmazon().getCreatedAt());

        amazonPrices.setLowestPricingAmazon(productDetailsDto.getLowestPricingAmazon().getPrice());
        amazonPrices.setDateLowestPricingAmazon(productDetailsDto.getLowestPricingAmazon().getCreatedAt());

       thirdPartPrices.setDateHighestPriceThirdPart(productDetailsDto.getHighestPriceThirdPart().getCreatedAt());
       thirdPartPrices.setHighestPriceThirdPart(productDetailsDto.getHighestPriceThirdPart().getPrice());

       thirdPartPrices.setCurrentPriceThirdPart(productDetailsDto.getCurrentPriceThirdPart().getPrice());
       thirdPartPrices.setDateCurrentPriceThirdPart(productDetailsDto.getCurrentPriceThirdPart().getCreatedAt());
       thirdPartPrices.setLowestPricingThirdPart(productDetailsDto.getLowestPricingThirdPart().getPrice());
       thirdPartPrices.setDateLowestPricingThirdPart(productDetailsDto.getLowestPricingThirdPart().getCreatedAt());
    }
}
