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

public class AlertForm extends FormLayout {

    private TextField url = new TextField("AMAZON URL");
    private ComboBox<Country> country = new ComboBox<>("Country");
    private TextField requestedPrice = new TextField("Requested Price");
    private TextField email = new TextField("Email");

    Button getAlertButton = new Button("Get price alert");
    private final Binder<AlertRequest> binder = new Binder<>(AlertRequest.class);

    private MainView mainView;

    private ProductService service = ProductService.getInstance();

    public AlertForm(MainView mainView){
        this.mainView = mainView;
        country.setItems(Country.values());
        HorizontalLayout layout = new HorizontalLayout(getAlertButton);
        getAlertButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(url, country, requestedPrice, email, layout);
        binder.bindInstanceFields(this);

        getAlertButton.addClickListener(event -> sendAlertRequest());
    }

    private void sendAlertRequest(){
        AlertRequest alertRequest = binder.getBean();
   //     service.sendAlertRequestToBackend(alertRequest.getUrl(),
    //            alertRequest.getCountry(),alertRequest.getRequestedPrice(),alertRequest.getEmail());

        service.sendAlertRequestToBackend(alertRequest);
        setAlertRequest(null);

    }
    public void setAlertRequest(AlertRequest alertRequest){
        binder.setBean(alertRequest);

        if(alertRequest == null){
            setVisible(false);
        } else {
            setVisible(true);
            url.focus();
        }
    }
}
