package com.vaadin.demo.views;

import com.vaadin.demo.MainView;
import com.vaadin.demo.components.ExAddContent;
import com.vaadin.demo.components.ExCard;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "pricing", layout = MainView.class)
@PageTitle("Pricing")
@Tag("pricing-view")
@JsModule("./src/views/pricing-view.js")
public class PricingView extends PolymerTemplate<TemplateModel> {

    @Id("header")
    Div header;

    @Id("main")
    Div main;

    @Id("footer")
    Div footer;

    public PricingView() {
        createHeader();

        Div hero = new Div();
        hero.addClassName("hero");
        hero.add(new H1("Pricing"));
        hero.add(new Paragraph(
                "Quickly build an effective pricing table for your potential"
                        + " customers with this Vaadin layout example. It’s built"
                        + " with Vaadin components and utilities some customization."));
        main.add(hero);

        Div cardList = new Div();
        cardList.addClassName("card-list");
        ExCard card;
        Button button;

        card = new ExCard("Free");
        card.add(new UnorderedList(new ListItem("10 users included"),
                new ListItem("2 GB of storage"), new ListItem("Email support"),
                new ListItem("Help center access")));
        card.add(new Button("Sign up for free"));
        cardList.add(card);

        card = new ExCard("Pro");
        card.add(new UnorderedList(new ListItem("20 users included"),
                new ListItem("10 GB of storage"),
                new ListItem("Priority email support"),
                new ListItem("Help center access")));
        button = new Button("Get started");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        card.add(button);
        cardList.add(card);

        card = new ExCard("Enterprise");
        card.add(new UnorderedList(new ListItem("30 users included"),
                new ListItem("15 GB of storage"),
                new ListItem("Phone and email support"),
                new ListItem("Help center access")));
        button = new Button("Contact us");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        card.add(button);
        cardList.add(card);

        main.add(cardList);

        main.add(new ExAddContent());

        createFooter();
    }

    public Component createTopMenu() {
        MenuBar menuBar = new MenuBar();
        menuBar.addThemeVariants(MenuBarVariant.LUMO_TERTIARY);
        menuBar.addItem(new Anchor("#features", "Features"));
        menuBar.addItem(new Anchor("#enterprise", "Enterprise"));
        menuBar.addItem(new Anchor("#support", "Support"));
        menuBar.addItem(new Anchor("#pricing", "Pricing"));
        menuBar.addItem(new Button("Sign up"));
        return menuBar;
    }

    public void createHeader() {
        header.add(new H2("Company name"), createTopMenu());
    }

    private void createFooter() {
        Div box;

        box = new Div();
        box.addClassName("copyright-box");
        Paragraph copyright = new Paragraph("© 2019");
        copyright.addClassName("copyright");
        box.add(new Icon(VaadinIcon.VAADIN_H), copyright);
        footer.add(box);

        box = new Div();
        box.add(new H2("Features"));
        box.add(new UnorderedList(new ListItem(new Anchor("#", "Cool stuff")),
                new ListItem(new Anchor("#", "Random feature")),
                new ListItem(new Anchor("#", "Team feature")),
                new ListItem(new Anchor("#", "Stuff for developers")),
                new ListItem(new Anchor("#", "Another one")),
                new ListItem(new Anchor("#", "Last time"))));
        footer.add(box);

        box = new Div();
        box.add(new H2("Resources"));
        box.add(new UnorderedList(new ListItem(new Anchor("#", "Resource")),
                new ListItem(new Anchor("#", "Resource name")),
                new ListItem(new Anchor("#", "Another resource")),
                new ListItem(new Anchor("#", "Final resource"))));
        footer.add(box);

        box = new Div();
        box.add(new H2("About"));
        box.add(new UnorderedList(new ListItem(new Anchor("#", "Team")),
                new ListItem(new Anchor("#", "Locations")),
                new ListItem(new Anchor("#", "Privacy")),
                new ListItem(new Anchor("#", "Terms"))));
        footer.add(box);
    }
}
