package com.vaadin.demo.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("marketing")
@PageTitle("Marketing form")
public class MarketingFormView extends VerticalLayout {

    public MarketingFormView() {

        setSizeFull();
        setSpacing(true);
        setPadding(true);

        MenuBar menuBar = new MenuBar();
        menuBar.getStyle().set("flex-grow", "1");
        MenuItem home = menuBar.addItem("Home");
        MenuItem disabled = menuBar.addItem("Disabled");
        disabled.setEnabled(false);
        MenuItem dropdown = menuBar.addItem("Dropdown");
        SubMenu dropdownSubMenu = dropdown.getSubMenu();
        MenuItem action = dropdownSubMenu.addItem("Ation");
        MenuItem anotherAction = dropdownSubMenu.addItem("Another action");
        MenuItem somethingElseHere = dropdownSubMenu
                .addItem("Something else here");

        // This HorizontalLayout contains the menuBar, searchTextField and
        // searchButton.
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setWidthFull();
        TextField searchTextField = new TextField();
        searchTextField.setPlaceholder("Search");
        Button searchButton = new Button("Search");
        headerLayout.add(menuBar, searchTextField, searchButton);
        headerLayout.getStyle().set("background-color", "#D5D8DC");

        // This VerticalLayout contains the header, contentDiv and button.
        VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.getStyle().set("padding-left", "20%");
        contentLayout.getStyle().set("padding-right", "20%");
        contentLayout.getStyle().set("background-color", "#F5F5F5");

        // It removes extra space above the contentLayout.
        contentLayout.getStyle().set("margin", "0");

        contentLayout.setHeight("50%");
        contentLayout.setWidthFull();
        contentLayout.setSpacing(false);

        H1 header = new H1("Hello, world!");
        header.setWidthFull();
        Div contentDiv = new Div();
        contentDiv.setText(
                "This is a template for a simple marketing or informational "
                        + "website. It includes three supporting pieces of "
                        + "content. Use it as a starting point to create "
                        + "something more unique.");
        Button button = new Button("Learn more >>");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        contentLayout.add(header, contentDiv, button);

        // This HorizontalLayout contains box1, box2 and box3.
        HorizontalLayout boxContainer = new HorizontalLayout();
        boxContainer.getStyle().set("flex-wrap", "wrap");
        boxContainer.setSizeFull();
        boxContainer.getStyle().set("padding-left", "20%");
        boxContainer.getStyle().set("padding-right", "20%");

        // This VerticalLayout contains box1Header, box1ContentDiv and
        // box1Button.
        VerticalLayout box1 = new VerticalLayout();
        box1.setWidth("30%");
        box1.setMinWidth("250px");
        H2 box1Header = new H2("Heading");
        Div box1ContentDiv = new Div();
        box1ContentDiv.setText(
                "Donec id elit non mi porta gravida at eget metus. Fusce "
                        + "dapibus, tellus ac cursus commodo, tortor mauris "
                        + "condimentum nibh, ut fermentum massa justo sit amet "
                        + "risus. Etiam porta sem malesuada magna mollis "
                        + "euismod. Donec sed odio dui.");
        Button box1Button = new Button("View details >>");
        box1Button.addThemeVariants(ButtonVariant.LUMO_SMALL);
        box1.add(box1Header, box1ContentDiv, box1Button);

        // This VerticalLayout contains box2Header, box2ContentDiv and
        // box2Button.
        VerticalLayout box2 = new VerticalLayout();
        box2.setWidth("30%");
        box2.setMinWidth("250px");
        H2 box2Header = new H2("Heading");
        Div box2ContentDiv = new Div();
        box2ContentDiv.setText(
                "Donec id elit non mi porta gravida at eget metus. Fusce "
                        + "dapibus, tellus ac cursus commodo, tortor mauris "
                        + "condimentum nibh, ut fermentum massa justo sit amet "
                        + "risus. Etiam porta sem malesuada magna mollis "
                        + "euismod. Donec sed odio dui.");
        Button box2Button = new Button("View details >>");
        box2Button.addThemeVariants(ButtonVariant.LUMO_SMALL);
        box2.add(box2Header, box2ContentDiv, box2Button);

        // This VerticalLayout contains box3Header, box3ContentDiv and
        // box3Button.
        VerticalLayout box3 = new VerticalLayout();
        box3.setWidth("30%");
        box3.setMinWidth("250px");
        H2 box3Header = new H2("Heading");
        Div box3ContentDiv = new Div();
        box3ContentDiv.setText(
                "Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, "
                        + "egestas eget quam. Vestibulum id ligula porta felis "
                        + "euismod semper. Fusce dapibus, tellus ac cursus "
                        + "commodo, tortor mauris condimentum nibh, ut fermentum "
                        + "massa justo sit amet risus.");
        Button box3Button = new Button("View details >>");
        box3Button.addThemeVariants(ButtonVariant.LUMO_SMALL);
        box3.add(box3Header, box3ContentDiv, box3Button);

        boxContainer.add(box1, box2, box3);
        add(headerLayout, contentLayout, boxContainer);
    }
}
