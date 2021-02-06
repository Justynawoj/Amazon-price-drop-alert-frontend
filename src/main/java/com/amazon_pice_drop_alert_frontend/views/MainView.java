package com.amazon_pice_drop_alert_frontend.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;


@Route
public class MainView extends VerticalLayout {

    public static final String BACKEND_URL = "http://localhost:8080/";
    private TextField urlField = new TextField();


    public MainView() {
        add(new H1("AMAZON PRICE DROP APP"));

    }
}
