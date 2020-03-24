package com.vaadin.demo.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("marketing")
@PageTitle("Marketing page")
public class MarketingView extends VerticalLayout {

    public MarketingView() {
        setSizeFull();
        setSpacing(true);
        setPadding(true);

        // This VerticalLayout contains the header, contentDiv and button.
        VerticalLayout layout = new VerticalLayout();
        layout.getStyle().set("padding-left", "20%");
        layout.getStyle().set("padding-right", "20%");
        layout.getStyle().set("background-color", "#F5F5F5");
        layout.getStyle().set("flex-shrink", "0");
        layout.setHeight("50%");
        layout.setWidthFull();
        layout.setSpacing(false);

        H1 header = new H1("Hello, world!");
        header.setWidthFull();
        Div contentDiv = new Div();
        contentDiv.setText(
                "This is a template for a simple marketing or informational "
                        + "website. It includes three supporting pieces of "
                        + "content. Use it as a starting point to create "
                        + "something more unique.");
        Button button = new Button("Learn more",
                new Icon(VaadinIcon.ANGLE_DOUBLE_RIGHT));
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        layout.add(header, contentDiv, button);

        // This HorizontalLayout contains box1, box2 and box3.
        HorizontalLayout container = new HorizontalLayout();
        container.setSpacing(false);
        container.getStyle().set("flex-wrap", "wrap");
        container.setSizeFull();
        container.getStyle().set("padding-left", "20%");
        container.getStyle().set("padding-right", "20%");

        String cardHeader = "Heading";
        String cardContent = "Donec id elit non mi porta gravida at eget"
                + " metus. Fusce dapibus, tellus ac cursus commodo, tortor"
                + " mauris condimentum nibh, ut fermentum massa justo sit amet "
                + "risus. Etiam porta sem malesuada magna mollis  euismod. "
                + "Donec sed odio dui.";

        Component card1 = createCard(cardHeader, cardContent);
        Component card2 = createCard(cardHeader, cardContent);
        Component card3 = createCard(cardHeader, cardContent);

        container.add(card1, card2, card3);
        Button sourceButton = new Button("View source code",
                new Image("icons/Github.png", "View source code"),
                event -> UI.getCurrent().getPage().setLocation(
                        "https://github.com/vaadin/layout-examples/blob/master/src/main/java/com/vaadin/demo/views/MarketingView.java"));

        add(layout, container, sourceButton);
    }

    private Component createCard(String cardHeader, String cardContent) {
        VerticalLayout layout = new VerticalLayout();
        layout.setWidth("30%");
        layout.setMinWidth("250px");

        H2 header = new H2(cardHeader);
        Div content = new Div();
        content.setText(cardContent);

        Button button = new Button("View details",
                new Icon(VaadinIcon.ANGLE_DOUBLE_RIGHT));
        button.addThemeVariants(ButtonVariant.LUMO_SMALL);

        layout.getElement().getStyle().set("flex-grow", "1");
        layout.add(header, content, button);
        return layout;
    }
}
