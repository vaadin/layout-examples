package com.vaadin.demo.views;

import com.vaadin.demo.MainView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "app-layout-basic", layout = MainView.class)
@PageTitle("Basic App Layout")
public class BasicAppLayoutView extends AppLayout {

    public BasicAppLayoutView() {
        Image img = new Image("https://i.imgur.com/GPpnszs.png", "Vaadin Logo");
        img.setHeight("44px");
        addToNavbar(new DrawerToggle(), img);
        Tabs tabs = new Tabs(new Tab("Home"), new Tab("About"));
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(tabs);
        VerticalLayout main = new VerticalLayout();

        Button sourceButton = new Button("View source code",
                new Image("icons/Github.png", "View source code"),
                event -> UI.getCurrent().getPage().setLocation(
                        "https://github.com/vaadin/layout-examples/blob/master/src/main/java/com/vaadin/demo/views/BasicAppLayoutView.java"));

        main.add(new H1("Header text"),
                new Paragraph("Main content goes here."), sourceButton);
        setContent(main);
    }
}
