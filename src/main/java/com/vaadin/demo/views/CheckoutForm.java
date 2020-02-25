package com.vaadin.demo.views;

import com.vaadin.demo.views.entity.Product;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Route("checkout-form")
@PageTitle("Checkout form")
public class CheckoutForm extends VerticalLayout {

    public CheckoutForm() {

        setAlignItems(Alignment.CENTER);
        setSpacing(true);
        setPadding(true);
        getStyle().set("padding-left", "20%");
        getStyle().set("padding-right", "20%");
        setWidthFull();

        Div header = new Div();
        header.setWidthFull();
        header.setHeight("150px");
        header.setText("Checkout form");
        header.getStyle().set("flexShrink", "0");
        header.getStyle().set("text-align", "center");
        header.getStyle().set("font-size", "xx-large");
        header.getStyle().set("font-weight", "bold");


        HorizontalLayout contentLayout = new HorizontalLayout();
        contentLayout.getStyle().set("flex-wrap", "wrap");
        contentLayout.getStyle().set("flex-direction", "row-reverse");
        contentLayout.setHeightFull();
        contentLayout.setWidthFull();

        FormLayout formLayout = new FormLayout();

        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("10em", 1, FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("20em", 3, FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("30em", 6, FormLayout.ResponsiveStep.LabelsPosition.TOP));

        formLayout.setWidth("65%");
        formLayout.setMinWidth("300px");
        formLayout.getElement().getStyle().set("flex-grow", "1");

        Div headerDiv = new Div();
        headerDiv.getStyle().set("margin", "10px");
        headerDiv.setWidth("100%");
        headerDiv.setText("Billing address");
        formLayout.setColspan(formLayout.addFormItem(headerDiv, ""), 6);
        formLayout.getElement().appendChild(ElementFactory.createBr());

        TextField name = new TextField();
        name.setWidth("100%");
        formLayout.setColspan(formLayout.addFormItem(name, "Name"), 3);

        TextField lastName = new TextField();
        lastName.setWidth("100%");
        formLayout.setColspan(formLayout.addFormItem(lastName, "Last name"), 3);


        TextField username = new TextField();
        username.setWidth("100%");
        formLayout.setColspan(formLayout.addFormItem(username, "Username"), 6);


        TextField email = new TextField();
        email.setWidth("100%");
        email.setPlaceholder("you@example.com");
        formLayout.setColspan(formLayout.addFormItem(email, "Email (Optional)"), 6);

        TextField address1 = new TextField();
        address1.setWidth("100%");
        address1.setPlaceholder("1234 Main St");
        formLayout.setColspan(formLayout.addFormItem(address1, "Address"), 6);

        TextField address2 = new TextField();
        address2.setWidth("100%");
        address2.setPlaceholder("Apartment or suite");
        formLayout.setColspan(formLayout.addFormItem(address2, "Address2 (Optional)"), 6);

        Select<String> country = new Select<>();
        country.setWidth("100%");
        country.setItems("United States");
        formLayout.setColspan(formLayout.addFormItem(country, "Country"), 2);

        Select<String> state = new Select<>();
        state.setWidth("100%");
        state.setItems("California");
        formLayout.setColspan(formLayout.addFormItem(state, "State"), 2);

        TextField zip = new TextField();
        zip.setWidth("50%");
        formLayout.setColspan(formLayout.addFormItem(zip, "Zip"), 2);

        Checkbox shippingAddress = new Checkbox();
        shippingAddress.setWidth("100%");
        shippingAddress.setLabel("Shipping address is the same as my billing address");
        formLayout.setColspan(formLayout.addFormItem(shippingAddress, ""), 6);
        formLayout.getElement().appendChild(ElementFactory.createBr());

        Checkbox saveInformation = new Checkbox();
        saveInformation.setWidth("100%");
        saveInformation.setLabel("Save this information for next time");
        formLayout.setColspan(formLayout.addFormItem(saveInformation, ""), 6);
        formLayout.getElement().appendChild(ElementFactory.createBr());

        Div paymentHeader = new Div();
        paymentHeader.setWidth("100%");
        formLayout.setColspan(formLayout.addFormItem(paymentHeader, "Payment"), 6);
        formLayout.getElement().appendChild(ElementFactory.createBr());

        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.setItems("Credit card", "Debit card", "PayPal");
        radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        formLayout.setColspan(formLayout.addFormItem(radioGroup, ""), 6);
        formLayout.getElement().appendChild(ElementFactory.createBr());

        TextField nameOnCard = new TextField();
        nameOnCard.setWidth("100%");
        formLayout.setColspan(formLayout.addFormItem(nameOnCard, "Name on card"), 3);

        TextField creditCardNumber = new TextField();
        creditCardNumber.setWidth("100%");
        formLayout.setColspan(formLayout.addFormItem(creditCardNumber, "Credit card number"), 3);

        TextField expiration = new TextField();
        expiration.setWidth("100%");
        formLayout.setColspan(formLayout.addFormItem(expiration, "Expiration"), 1);

        TextField cVV = new TextField();
        cVV.setWidth("100%");
        formLayout.setColspan(formLayout.addFormItem(cVV, "CVV"), 1);

        Button saveButton = new Button("Continue to checkout");
        saveButton.addThemeVariants(ButtonVariant.LUMO_LARGE,
                ButtonVariant.LUMO_PRIMARY);

        List<Product> list = new ArrayList<>();
        list.add(new Product("Vanilla cracker", 12, "With wholemeal flour"));
        list.add(new Product("Vanilla blueberry cake", 8, "With blueberry jam"));
        list.add(new Product("Vanilla pastry", 5, "with wholemeal flour"));
        list.add(new Product("Blueberry cheese cake", 5, "With blueberry jam"));

        Grid<Product> grid = new Grid<>();

        grid.setItems(list);
        grid.setWidth("30%");
        grid.setMinWidth("250px");
        grid.getElement().getStyle().set("flex-grow", "1");
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);

        grid.addColumn(TemplateRenderer.<Product>of(
                "<div><b>[[item.name]]</b><br> <small>[[item.description]]</small></div>")
                .withProperty("name", Product::getName)
                .withProperty("description", Product::getDescription));
        grid.addColumn(TemplateRenderer.<Product>of(
                "<div>[[item.price]]</div>")
                .withProperty("price", order -> moneyFormat.format(order.getPrice())));

        contentLayout.add(grid, formLayout);
        add(header, contentLayout, saveButton);
    }
}
