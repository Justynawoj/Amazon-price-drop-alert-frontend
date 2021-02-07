package com.amazon_pice_drop_alert_frontend.views;

import com.amazon_pice_drop_alert_frontend.models.*;
import com.amazon_pice_drop_alert_frontend.services.ProductService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;


@Route
public class MainView extends VerticalLayout {

    public static final String BACKEND_URL = "http://localhost:8080/";
    private Grid grid = new Grid<>(ProductInfo.class, false);
    private Grid grid2 = new Grid<>(AmazonPrices.class);
    private Grid grid3 = new Grid<>(ThirdPartPrices.class);

    private TextField url = new TextField("url");
    private ComboBox<Country> countryComboBox = new ComboBox<>("Country");

    ProductService service = ProductService.getInstance();

    private ProductForm form = new ProductForm(this);
    Button getInfo = new Button("Get Info");


    public MainView() {
        add(new H1("AMAZON PRICE DROP APP"));

        add(getInfo);

        getInfo.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setProduct(new Request());
        });

        HorizontalLayout toolbar = new HorizontalLayout(getInfo);
        HorizontalLayout mainContent = new HorizontalLayout(form,grid);
        VerticalLayout verticalLayout = new VerticalLayout(grid2);
        VerticalLayout verticalLayout2 = new VerticalLayout(grid3);
        mainContent.setSizeFull();
        verticalLayout.setSizeFull();
        verticalLayout2.setSizeFull();

        grid.removeAllColumns();
        grid.addColumn("title");
        grid.addColumn("asin");
        grid.addColumn("createdAt");
        grid.addColumn("currencySymbol");
        grid.getColumnByKey("title").setWidth("400px");

        grid.setSizeFull();
        grid2.setSizeFull();
        grid3.setSizeFull();

        add(toolbar, mainContent,verticalLayout,verticalLayout2);
        //ukrywa formularz
        form.setProduct(null);
        setSizeFull();

        refresh();

        grid.asSingleSelect().addValueChangeListener(
                event -> form.setProduct(
                (Request) grid.asSingleSelect().getValue()));
    }

    public void refresh() {
        grid.setItems(service.getProductInfo());
        grid2.setItems(service.getAmazonPrices());
        grid3.setItems(service.getThirdPartPrices());
    }

}
