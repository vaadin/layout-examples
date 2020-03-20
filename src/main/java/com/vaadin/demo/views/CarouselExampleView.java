package com.vaadin.demo.views;

import com.flowingcode.vaadin.addons.carousel.Carousel;
import com.flowingcode.vaadin.addons.carousel.Slide;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("carousel")
@PageTitle("Carousel example")
public class CarouselExampleView extends VerticalLayout {

    public CarouselExampleView() {

        // A carousel contains multiple slides. Each slide can contain other
        // components. In this example, for each slide we have one layout
        // component. This program uses a 3rd party addon and to use it,
        // required dependency must be added to the pom.xml
        // More information can be found here:
        // https://vaadin.com/directory/component/carousel-addon/
        Slide slide1 = new Slide(createSlide1Layout());
        Slide slide2 = new Slide(createSlide2Layout());
        Slide slide3 = new Slide(createSlide3Layout());

        Carousel carousel = new Carousel(slide1, slide2, slide3)
                .withAutoProgress().withSlideDuration(4).withStartPosition(0);
        carousel.setHideNavigation(false);
        carousel.setWidthFull();
        carousel.setHeight("500px");

        Button sourceButton = new Button("View source code",
                new Image("icons/Github.png", "View source code"),
                event -> UI.getCurrent().getPage().setLocation(
                        "https://github.com/vaadin/layout-examples/blob/master/src/main/java/com/vaadin/demo/views/CarouselExampleView.java"));

        add(carousel, sourceButton);
    }

    private Component createSlide3Layout() {
        // Content of the right slide
        VerticalLayout layout = new VerticalLayout();
        configSlideLayout(layout);

        H1 headLine = new H1();
        headLine.setText("One more for good measure.");
        headLine.getStyle().set("align-self", "flex-end");
        headLine.getStyle().set("color", "white");

        Div content = new Div();
        content.getStyle().set("white-space", "pre-wrap");
        content.setText("Cras justo odio, dapibus ac facilisis in, egestas"
                + " eget quam. Donec id elit non mi porta gravida at eget"
                + " metus. Nullam id dolor id nibh ultricies vehicula ut id "
                + "elit.");
        content.getStyle().set("align-self", "flex-end");
        content.getStyle().set("color", "white");
        content.getStyle().set("text-align", "end");

        Button button = new Button("Browse gallery");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addThemeVariants(ButtonVariant.LUMO_LARGE);
        // Align button to right
        button.getStyle().set("margin-left", "auto");
        layout.add(button, content, headLine);
        return layout;
    }

    private Component createSlide2Layout() {
        // Content of the second slide
        VerticalLayout layout = new VerticalLayout();
        configSlideLayout(layout);

        H1 headLine = new H1();
        headLine.setText("Another example headline.");
        headLine.getStyle().set("align-self", "center");
        headLine.getStyle().set("color", "white");
        Div content = new Div();

        content.getStyle().set("white-space", "pre-wrap");
        content.getStyle().set("text-align", "center");

        content.setText("Cras justo odio, dapibus ac facilisis in, egestas"
                + " eget quam. Donec id elit non mi porta gravida at "
                + "eget metus. Nullam id dolor id nibh ultricies "
                + "vehicula ut id elit.");
        content.getStyle().set("align-self", "center");
        content.getStyle().set("color", "white");
        Button button = new Button("Sign up today");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addThemeVariants(ButtonVariant.LUMO_LARGE);
        // Align button to center
        button.getStyle().set("margin-left", "auto");
        button.getStyle().set("margin-right", "auto");
        layout.add(button, content, headLine);
        return layout;
    }

    private Component createSlide1Layout() {
        // Content of the third slide
        VerticalLayout layout = new VerticalLayout();
        configSlideLayout(layout);

        H1 headLine = new H1();
        headLine.setText("Example headline.");
        headLine.getStyle().set("color", "white");
        Div content = new Div();
        layout.getStyle().set("background-color", "#737A84");
        content.setText(
                "Cras justo odio, dapibus ac facilisis in, egestas eget quam. "
                        + "Donec id elit non mi porta gravida at eget metus. "
                        + "Nullam id dolor id nibh ultricies vehicula ut id"
                        + " elit.");
        content.getStyle().set("color", "white");
        content.getStyle().set("white-space", "pre-wrap");
        Button button = new Button("Sign up today");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addThemeVariants(ButtonVariant.LUMO_LARGE);
        layout.add(button, content, headLine);
        return layout;
    }

    private void configSlideLayout(VerticalLayout verticalLayout) {
        setAlignItems(FlexComponent.Alignment.CENTER);
        verticalLayout.setSizeFull();
        verticalLayout.getStyle().set("padding-left", "10%");
        verticalLayout.getStyle().set("padding-right", "10%");
        verticalLayout.getStyle().set("padding-bottom", "10%");
        verticalLayout.getStyle().set("flex-direction", "column-reverse");
        verticalLayout.getStyle().set("background-color", "#737A84");
    }
}
