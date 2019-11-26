package com.vaadin.demo.views;

import com.vaadin.demo.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "centered-content", layout = MainView.class)
@PageTitle("Centered Content")
@Tag("centered-content-view")
@JsModule("./src/views/centered-content-view.js")
public class CenteredContentView extends PolymerTemplate<TemplateModel> {

    @Id("main")
    Div main;

    public CenteredContentView() {
        main.add(new Paragraph("Main content goes here."));
    }
}
