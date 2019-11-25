package com.vaadin.demo.views;

import com.vaadin.demo.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "two-columns", layout = MainView.class)
@PageTitle("Two Columns")
@Tag("two-columns-view")
@JsModule("./src/views/two-columns-view.js")
public class TwoColumnsView extends PolymerTemplate<TemplateModel> {

    @Id("header")
    Div header;

    @Id("sidebar")
    Div sidebar;

    @Id("main")
    Div main;

    @Id("footer")
    Div footer;

    public TwoColumnsView() {
        header.add(new H1("Header text"));
        sidebar.add(new VerticalLayout(new Anchor("", "Link 1"),
                new Anchor("", "Link 2"), new Anchor("", "Link 3"),
                new Anchor("", "Link 4")));
        main.add(new Paragraph("Main content goes here."));
        footer.add(new Paragraph("Footer text"));
    }
}
