package com.vaadin.demo.views;

import com.vaadin.demo.entity.Product;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Route("checkout-form")
@PageTitle("Checkout form")
@CssImport("./styles/checkoutform.css")
public class CheckoutFormView extends VerticalLayout {

    public CheckoutFormView() {

        setAlignItems(Alignment.CENTER);
        setSpacing(true);
        setPadding(true);
        getStyle().set("padding-left", "10%");
        getStyle().set("padding-right", "10%");
        setWidthFull();

        // This VerticalLayout contains addressHeader, formLayout, saveButton
        VerticalLayout billingAddressLayout = new VerticalLayout();
        billingAddressLayout.setWidth("65%");
        billingAddressLayout.setMinWidth("300px");
        billingAddressLayout.setSpacing(true);
        billingAddressLayout.setPadding(false);

        // Flex-grow of the formLayout and Grid are set to 1 to be grown with
        // the same portion.
        billingAddressLayout.getElement().getStyle().set("flex-grow", "1");

        // Main header of the form
        H1 header = new H1();
        header.setText("Checkout form");
        header.setWidthFull();
        header.getStyle().set("text-align", "center");
        header.getStyle().set("font-weight", "bold");

        // To give the page the ability of wrapping, a HorizontalLayout is used,
        // it contains a formLayout and a grid. flex-wrap and flex-direction
        // help to wrap the page and give the direction of wrapping.
        // When it is wrapped Grid goes up.
        HorizontalLayout contentLayout = new HorizontalLayout();
        contentLayout.addClassName("contentlayout");
        contentLayout.setSpacing(false);
        contentLayout.setHeightFull();
        contentLayout.setWidthFull();

        // A formLayout is used to add the fields. It is also responsive.
        FormLayout formLayout = new FormLayout();
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("10em", 1,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("20em", 3,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("30em", 6,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP));

        formLayout.setWidthFull();

        // Header for the Billing address fields.
        H2 addressHeader = new H2();
        addressHeader.setText("Billing address");
        addressHeader.getStyle().set("margin", "0");

        // Items related to the billing address are created and added to the
        // FormLayout.
        TextField name = new TextField();
        name.setWidthFull();
        formLayout.setColspan(formLayout.addFormItem(name, "Name"), 3);

        TextField lastName = new TextField();
        lastName.setWidthFull();
        formLayout.setColspan(formLayout.addFormItem(lastName, "Last name"), 3);

        TextField username = new TextField();
        username.setWidthFull();
        formLayout.setColspan(formLayout.addFormItem(username, "Username"), 6);

        TextField email = new TextField();
        email.setWidthFull();
        email.setPlaceholder("you@example.com");
        formLayout.setColspan(formLayout.addFormItem(email, "Email (Optional)"),
                6);

        TextField address1 = new TextField();
        address1.setWidthFull();
        address1.setPlaceholder("1234 Main St");
        formLayout.setColspan(formLayout.addFormItem(address1, "Address"), 6);

        TextField address2 = new TextField();
        address2.setWidthFull();
        address2.setPlaceholder("Apartment or suite");
        formLayout.setColspan(
                formLayout.addFormItem(address2, "Address2 (Optional)"), 6);

        Select<String> country = new Select<>();
        country.setWidthFull();
        country.setItems("Finland", "Germany", "United States");
        formLayout.setColspan(formLayout.addFormItem(country, "Country"), 2);

        Select<String> state = new Select<>();
        state.setWidthFull();
        state.setItems("Florida", "California", "Texas", "Utah");
        formLayout.setColspan(formLayout.addFormItem(state, "State"), 2);

        TextField zip = new TextField();
        zip.setWidthFull();
        formLayout.setColspan(formLayout.addFormItem(zip, "Zip"), 2);

        Hr upHR = new Hr();
        formLayout.setColspan(formLayout.addFormItem(upHR, ""), 6);

        Checkbox shippingAddress = new Checkbox();
        shippingAddress.setWidthFull();
        shippingAddress
                .setLabel("Shipping address is the same as my billing address");
        formLayout.setColspan(formLayout.addFormItem(shippingAddress, ""), 6);

        Checkbox saveInformation = new Checkbox();
        saveInformation.setWidthFull();
        saveInformation.setLabel("Save this information for next time");
        formLayout.setColspan(formLayout.addFormItem(saveInformation, ""), 6);

        Hr downHR = new Hr();
        formLayout.setColspan(formLayout.addFormItem(downHR, ""), 6);

        H2 paymentHeader = new H2();
        paymentHeader.setText("Payment");
        formLayout.setColspan(formLayout.addFormItem(paymentHeader, ""), 6);

        // Items related to payment are created and added to the FormLayout.
        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.setItems("Credit card", "Debit card", "PayPal");
        radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        formLayout.setColspan(formLayout.addFormItem(radioGroup, ""), 6);

        TextField nameOnCard = new TextField();
        nameOnCard.setWidthFull();
        formLayout.setColspan(
                formLayout.addFormItem(nameOnCard, "Name on card"), 3);

        TextField creditCardNumber = new TextField();
        creditCardNumber.setWidthFull();
        formLayout.setColspan(
                formLayout.addFormItem(creditCardNumber, "Credit card number"),
                3);

        TextField expiration = new TextField();
        expiration.setWidthFull();
        formLayout.setColspan(formLayout.addFormItem(expiration, "Expiration"),
                1);

        TextField cVV = new TextField();
        cVV.setWidthFull();
        formLayout.setColspan(formLayout.addFormItem(cVV, "CVV"), 1);

        Button saveButton = new Button("Continue to checkout",
                new Icon(VaadinIcon.ARROW_RIGHT));
        saveButton.addThemeVariants(ButtonVariant.LUMO_LARGE,
                ButtonVariant.LUMO_PRIMARY);

        // Aligns button to the right
        saveButton.getStyle().set("margin-left", "auto");

        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "Vanilla cracker", 7, "With wholemeal flour"));
        list.add(new Product(2, "Vanilla blueberry cake", 8,
                "With blueberry jam"));
        list.add(new Product(3, "Vanilla pastry", 5, "with wholemeal flour"));
        list.add(new Product(4, "Blueberry cheese cake", 5,
                "With blueberry jam"));

        // Using a grid to show the purchased items.
        Grid<Product> grid = new Grid<>();
        grid.setItems(list);
        grid.setWidth("30%");
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);

        // Using Template to show two properties, one on top of another
        // property.
        grid.addColumn(TemplateRenderer.<Product> of(
                "<div><b>[[item.name]]</b><br> <small>[[item.description]]</small></div>")
                .withProperty("name", Product::getName)
                .withProperty("description", Product::getDescription))
                .setWidth("70%");
        grid.addColumn(TemplateRenderer
                .<Product> of("<div>[[item.price]]</div>").withProperty("price",
                        order -> moneyFormat.format(order.getPrice())))
                .setTextAlign(ColumnTextAlign.END).setWidth("30%");

        Button sourceButton = new Button("View source code",
                new Image("icons/Github.png", "View source code"),
                event -> UI.getCurrent().getPage().setLocation(
                        "https://github.com/vaadin/layout-examples/blob/master/src/main/java/com/vaadin/demo/views/CheckoutFormView.java"));

        billingAddressLayout.add(addressHeader, formLayout, saveButton,
                sourceButton);
        contentLayout.add(grid, billingAddressLayout);
        add(header, contentLayout);
    }
}
