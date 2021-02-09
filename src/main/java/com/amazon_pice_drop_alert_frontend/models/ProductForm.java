package com.amazon_pice_drop_alert_frontend.models;

import com.amazon_pice_drop_alert_frontend.services.ProductService;
import com.amazon_pice_drop_alert_frontend.views.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;


public class ProductForm extends FormLayout {

    private TextField url = new TextField("AMAZON URL");
    private ComboBox<Country> countryType = new ComboBox<>("Country");

    private Button search = new Button("Get price history");
    private final Binder<PriceRequestDto> binder = new Binder<>(PriceRequestDto.class);
    private MainView mainView;

    private ProductService service = ProductService.getInstance();

    public ProductForm(MainView mainView) {
        this.mainView = mainView;
        countryType.setItems(Country.values());
        HorizontalLayout buttons = new HorizontalLayout(search);
        search.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(url, countryType, buttons);
        binder.bindInstanceFields(this);

        search.addClickListener(event -> search());
    }

    private void search() {
        PriceRequestDto priceRequestDto = binder.getBean();
        service.sendRequestToBackend(priceRequestDto.getUrl(), priceRequestDto.getCountryType());
        mainView.refresh();
        setRequest(null);
    }

    public void setRequest(PriceRequestDto priceRequestDto) {
        binder.setBean(priceRequestDto);

        if (priceRequestDto == null) {
            setVisible(false);
        } else {
            setVisible(true);
            url.focus();
        }

    }
}
