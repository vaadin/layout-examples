package com.vaadin.demo;

import org.vaadin.googleanalytics.tracking.EnableGoogleAnalytics;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * The main view is a top-level placeholder for other views.
 */
@JsModule("./styles/shared-styles.js")
@JsModule("./src/utils.js")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@EnableGoogleAnalytics(value = "UA-658457-6", pageviewPrefix = "layout-examples/")
@BodySize
public class MainView extends Div implements RouterLayout {
    public MainView() {
        getElement().getStyle().set("height", "100%");
    }
}
