package com.vaadin.demo.views;

import com.vaadin.demo.AppNavLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "", layout = AppNavLayout.class)
@PageTitle("Layout Examples for Vaadin 14")
@Tag("intro-view")
@JsModule("./src/views/intro-view.js")
public class IntroView extends PolymerTemplate<TemplateModel> {
}
