package com.vaadin.demo.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

/**
 * Server-side component for the {@code ex-card} example card element.
 */
@Tag("ex-card")
@JsModule("./src/components/ex-card.js")
public class ExCard extends Component implements HasStyle, HasComponents {

    public ExCard(String title) {
        setTitle(title);
    }

    public String getTitle() {
        return getElement().getProperty("title");
    }

    public void setTitle(String title) {
        getElement().setProperty("title", title == null ? "" : title);
    }
}
