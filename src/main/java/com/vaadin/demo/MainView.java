package com.vaadin.demo;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.RouterLayout;

/**
 * The main view is a top-level placeholder for other views.
 */
@JsModule("./src/utils.js")
public class MainView extends Div implements RouterLayout {
    public MainView() {
        getElement().getStyle().set("height", "100%");
    }
}
