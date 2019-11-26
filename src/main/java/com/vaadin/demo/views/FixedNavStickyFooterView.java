package com.vaadin.demo.views;

import com.vaadin.demo.MainView;
import com.vaadin.demo.components.ExAddContent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "fixed-nav-sticky-footer", layout = MainView.class)
@PageTitle("Fixed Nav & Sticky Footer")
@Tag("fixed-nav-sticky-footer-view")
@JsModule("./src/views/fixed-nav-sticky-footer-view.js")
public class FixedNavStickyFooterView extends PolymerTemplate<TemplateModel> {

    @Id("header")
    Header header;

    @Id("main")
    Div main;

    @Id("footer")
    Div footer;

    public FixedNavStickyFooterView() {
        createHeader();

        main.add(new H1("Sticky footer with fixed navbar"));
        main.add(new Paragraph("Footer pinned to the bottom of the viewport."
                + " If there is more content than fits the viewport, the footer"
                + " will be pushed down and will be visible only when scrolled"
                + " to the bottom of the page."));
        main.add(new ExAddContent());

        footer.add(new Paragraph("Place sticky footer content here."));
    }

    public void createHeader() {
        RouterLink titleLink = new RouterLink("Fixed navbar", getClass());
        titleLink.addClassName("titleLink");
        header.add(titleLink);
        header.add(new RouterLink("Home", getClass()));
        header.add(new Anchor("#", "Link"));
        Anchor a = new Anchor("#", "Help");
        // Stretches this item in the flex container so that the following items
        // will be at the right side of the screen.
        a.getStyle().set("margin-right", "auto");
        header.add(a);

        Div searchBlock = new Div();
        searchBlock.addClassName("searchBlock");
        TextField searchField = new TextField();
        searchField.setPlaceholder("Search");
        searchField.addClassName("searchField");
        searchBlock.add(searchField);

        Button searchButton = new Button("Search");
        searchButton.addClassName("searchButton");
        searchBlock.add(searchButton);

        header.add(searchBlock);
    }
}
