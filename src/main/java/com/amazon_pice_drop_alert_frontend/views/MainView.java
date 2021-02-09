package com.amazon_pice_drop_alert_frontend.views;

import com.amazon_pice_drop_alert_frontend.models.*;
import com.amazon_pice_drop_alert_frontend.services.ProductService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public static final String BACKEND_URL = "http://localhost:8080/";
    private Grid infoGrid = new Grid<>(ProductInfo.class, false);
    private Grid amazonPricesGrid = new Grid<>(AmazonPrices.class);
    private Grid thirdPartPricesGrid = new Grid<>(ThirdPartPrices.class);

    ProductService service = ProductService.getInstance();

    private final ProductForm form = new ProductForm(this);
    private final AlertForm alertForm = new AlertForm(this);

    Button getInfo = new Button("Get Price Info");
    Button getPriceAlert = new Button("Get Price Alert");

    public MainView() {
        add(new H2("AMAZON PRICE DROP APP"));

        getInfo.addClickListener(e -> {
            infoGrid.asSingleSelect().clear();
            form.setRequest(new PriceRequestDto());
        });

        getPriceAlert.addClickListener(event -> {
            infoGrid.asSingleSelect().clear();
            alertForm.setAlertRequest(new AlertRequestDto());
        });

        HorizontalLayout toolbar = new HorizontalLayout(getInfo, getPriceAlert);
        HorizontalLayout mainContent = new HorizontalLayout(form, alertForm, infoGrid);
        H5 amazonPricesInfo = new H5("This is the price charged for New products when Amazon itself is the seller.");
        H5 thirdPartPricesInfo = new H5("This is the price charged by third party merchants for items in New condition.");
        thirdPartPricesInfo.setMinWidth(thirdPartPricesGrid.getWidth());

        HorizontalLayout infoLayout = new HorizontalLayout(amazonPricesInfo, thirdPartPricesInfo);
        HorizontalLayout pricesLayout = new HorizontalLayout(amazonPricesGrid, thirdPartPricesGrid);
        mainContent.setSizeFull();
        pricesLayout.setSizeFull();
        infoLayout.setSizeFull();

        infoGrid.removeAllColumns();
        infoGrid.addColumn("title");
        infoGrid.addColumn("createdAt");
        infoGrid.addColumn("currencySymbol");
        infoGrid.getColumnByKey("title").setWidth("400px");
        infoGrid.getColumnByKey("currencySymbol").setWidth("40px");
        infoGrid.getColumnByKey("currencySymbol").setHeader("Currency");

        amazonPricesGrid.removeAllColumns();
        amazonPricesGrid.addColumn("currentPriceAmazon").setHeader("Current Price").setWidth("60px");
        amazonPricesGrid.addColumn("highestPriceAmazon").setHeader("Highest Price").setWidth("60px");
        amazonPricesGrid.addColumn("dateHighestPriceAmazon").setHeader("Date").setWidth("30px");
        amazonPricesGrid.addColumn("lowestPricingAmazon").setHeader("Lowest Price").setWidth("50px");
        amazonPricesGrid.addColumn("dateLowestPricingAmazon").setHeader("Date").setWidth("30px");

        thirdPartPricesGrid.removeAllColumns();
        thirdPartPricesGrid.addColumn("currentPriceThirdPart").setHeader("Current Price New");
        thirdPartPricesGrid.addColumn("highestPriceThirdPart").setHeader("Highest Price New");
        thirdPartPricesGrid.addColumn("dateHighestPriceThirdPart").setHeader("Date");
        thirdPartPricesGrid.addColumn("lowestPricingThirdPart").setHeader("Lowest Price New");
        thirdPartPricesGrid.addColumn("dateLowestPricingThirdPart").setHeader("Date");

        infoGrid.setSizeFull();
        amazonPricesGrid.setSizeFull();
        amazonPricesGrid.setMaxWidth("650px");
        thirdPartPricesGrid.setSizeFull();

        add(toolbar, mainContent, infoLayout, pricesLayout);
        form.setRequest(null);
        alertForm.setAlertRequest(null);
        setSizeFull();
        refresh();

        infoGrid.asSingleSelect().addValueChangeListener(
                event -> form.setRequest(
                        (PriceRequestDto) infoGrid.asSingleSelect().getValue()));

        infoGrid.asSingleSelect().addValueChangeListener(
                event -> alertForm.setAlertRequest(
                        (AlertRequestDto) infoGrid.asSingleSelect().getValue()));
        Notification.show("Request sent!");
    }

    public void refresh() {
        infoGrid.setItems(service.getProductInfo());
        amazonPricesGrid.setItems(service.getAmazonPrices());
        thirdPartPricesGrid.setItems(service.getThirdPartPrices());
    }
}
