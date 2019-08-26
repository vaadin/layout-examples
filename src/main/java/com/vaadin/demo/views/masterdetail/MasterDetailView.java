package com.vaadin.demo.views.masterdetail;

import com.vaadin.demo.backend.BackendService;
import com.vaadin.demo.backend.Employee;
import com.vaadin.demo.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

import com.vaadin.demo.views.masterdetail.MasterDetailView.MasterDetailViewModel;

@Route(value = "masterdetail", layout = MainView.class)
@PageTitle("MasterDetail")
@JsModule("src/views/masterdetail/master-detail-view.js")
@Tag("master-detail-view")
public class MasterDetailView extends PolymerTemplate<MasterDetailViewModel> implements
        AfterNavigationObserver {

    public static interface MasterDetailViewModel extends TemplateModel {
    }

    private BackendService service;

    @Id
    private Grid<Employee> employees;

    @Id
    private TextField firstname;
    @Id
    private TextField lastname;
    @Id
    private TextField email;
    @Id
    private PasswordField password;

    @Id
    private Button cancel;
    @Id
    private Button save;

    private Binder<Employee> binder;

    public MasterDetailView() {
        service = new BackendService();
        // Configure Grid
        employees.addColumn(Employee::getFirstname).setHeader("First Name");
        employees.addColumn(Employee::getLastname).setHeader("Last Name");
        employees.addColumn(Employee::getEmail).setHeader("Email");

        //when a row is selected or deselected, populate form
        employees.asSingleSelect().addValueChangeListener(event -> populateForm(event.getValue()));

        // Configure Form
        binder = new Binder<>(Employee.class);

        // Bind fields. This where you'd define e.g. validation rules
        binder.bindInstanceFields(this);
        // note that password field isn't bound since that property doesn't exist in
        // Employee

        // the grid valueChangeEvent will clear the form too
        cancel.addClickListener(e -> employees.asSingleSelect().clear());

        save.addClickListener(e -> {
            Notification.show("Not implemented");
        });
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {

        // Lazy init of the grid items, happens only when we are sure the view will be
        // shown to the user
        employees.setItems(service.getEmployees());
    }

    private void populateForm(Employee value) {
        // Value can be null as well, that clears the form
        binder.readBean(value);

        // The password field isn't bound through the binder, so handle that
        password.setValue("");
    }
}
