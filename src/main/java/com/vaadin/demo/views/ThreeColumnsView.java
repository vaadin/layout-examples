package com.vaadin.demo.views;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.demo.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

@Route(value = "three-columns", layout = MainView.class)
@PageTitle("Three Columns")
@Tag("three-columns-view")
@JsModule("./src/views/three-columns-view.js")
public class ThreeColumnsView extends PolymerTemplate<TemplateModel> {

    @Id("header")
    Div header;

    @Id("sidebarLeft")
    Div sidebarLeft;

    @Id("sidebarRight")
    Div sidebarRight;

    @Id("main")
    Div main;

    @Id("footer")
    Div footer;

    public ThreeColumnsView() {
        header.add(new H1("Header text"));
        sidebarLeft.add(new VerticalLayout(new Anchor("", "Link 1"),
                new Anchor("", "Link 2"), new Anchor("", "Link 3"),
                new Anchor("", "Link 4")));
        sidebarRight.add(new VerticalLayout(new Anchor("", "Link 5"),
                new Anchor("", "Link 6")));
        main.add(new Paragraph("Main content goes here."));
        footer.add(new Paragraph("Footer text"));
    }
}
