package com.vaadin.demo.views;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("vertical")
@PageTitle("VerticalLayout Examples")
public class VerticalExamplesView extends VerticalLayout {

    public VerticalExamplesView() {
        setSpacing(true);
        setPadding(true);

        add(new H2("Vertical Layout Examples"));

        add(new Text("Each layout has a width of 600px, and a gray background color for better visibility."));

        category("Margin and Padding");

        VerticalLayout layout = createLayout("Basic example with default settings");
        layout.add(button("Button one"), button("Button two"));

        layout = createLayout("Basic example without spacing");
        layout.setSpacing(false);
        layout.add(button("Button one"), button("Button two"));

        layout = createLayout("Basic example with margins");
        layout.setMargin(true);
        layout.add(button("Button one"), button("Button two"));

        layout = createLayout("Basic example with padding");
        layout.setPadding(true);
        layout.add(button("Button one"), button("Button two"));

        layout = createLayout("Basic example with margin and padding");
        layout.setPadding(true);
        layout.setMargin(true);
        layout.add(button("Button one"), button("Button two"));

        category("Scrolling");

        layout = createLayout("Enable scrolling");
        layout.setPadding(true);
        layout.setHeight("300px");
        layout.add(button("Button"), button("Button"), button("Button"), button("Button"), button("Button"), button("Button"), button("Button"),
                button("Button"), button("Button"), button("Button"), button("Button"), button("Button"), button("Mushroom"), button("Mushroom"));
        layout.getStyle().set("overflow", "scroll");// enable scrolling when content doesn't fit

        layout = createLayout("Partial content scrolling with overflow");
        layout.setPadding(true);
        VerticalLayout scrollingLayout = new VerticalLayout(button("Button"), button("Button"), button("Button"), button("Button"), button("Button"), button("Button"), button("Button"),
                button("Button"), button("Button"), button("Button"), button("Button"), button("Button"), button("Mushroom"), button("Mushroom"));
        scrollingLayout.getStyle().set("background-color", "#eee");
        scrollingLayout.setPadding(false);
        scrollingLayout.setMaxHeight("190px"); // restrict the max height
        scrollingLayout.getStyle().set("overflow", "scroll"); // enable scrolling when content doesn't fit
        Button button = button("Click to add a button");
        button.addClickListener(e -> scrollingLayout.add(button("Contentbutton")));
        layout.add(button, scrollingLayout, button("Footerbutton"));

        category("Size and Positioning");

        layout = createLayout("Aligning all items");
        layout.setPadding(true);
        layout.setAlignItems(Alignment.END);
        layout.add(button("Button one"), button("Button two"));

        layout = createLayout("Aligning individual items");
        layout.setPadding(true);
        button = button("Align start");
        layout.add(button);
        layout.setHorizontalComponentAlignment(Alignment.START, button);
        button = button("Align center");
        layout.add(button);
        layout.setHorizontalComponentAlignment(Alignment.CENTER, button);
        button = button("Align end");
        layout.add(button);
        layout.setHorizontalComponentAlignment(Alignment.END, button);
        button = button("Strech");
        layout.add(button);
        layout.setHorizontalComponentAlignment(Alignment.STRETCH, button);

        layout = createLayout("Expanding one component");
        layout.setPadding(true);
        layout.setHeight("300px");
        button = button("Button one");
        layout.add(button, button("Button two"));
        layout.setFlexGrow(1, button); // this expands the button

        layout = createLayout("Expanding both components");
        layout.setPadding(true);
        layout.addAndExpand(button("Button one"), button("Button two")); // adds and flex-grows both components
        // setHeight needs to be defined last because of
        // https://github.com/vaadin/vaadin-ordered-layout-flow/issues/134
        layout.setHeight("300px");

        layout = createLayout("Split positioning (without expanding either component)");
        layout.setPadding(true);
        layout.setHeight("300px");
        button = button("Button two");
        button.getStyle().set("margin-top", "auto"); // expands the empty space above button two
        layout.add(button("Button one"), button);

        layout = createLayout("Advanced split positioning 1");
        layout.setPadding(true);
        layout.setHeight("400px");
        button = button("Button two");
        button.getStyle().set("margin-bottom", "auto");// expands the empty space below button two
        layout.add(button("Button one"), button, button("Button three"));

        layout = createLayout("Advanced split positioning 2");
        layout.setPadding(true);
        layout.setHeight("400px");
        button = button("Button two");
        button.getStyle().set("margin-top", "auto");// expands the empty space above button two
        layout.add(button("Button one"), button, button("Button three"));

    }

    private void category(String string) {
        add(new H3(string));
    }

    private Button button(String caption) {
        Button button = new Button(caption);
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        return button;
    }

    private VerticalLayout createLayout(String caption) {
        VerticalLayout hl = new VerticalLayout();
        hl.setWidth("600px");
        hl.getStyle().set("background-color", "#dddddd");
        add(new Text(caption));
        add(hl);
        add(new Html("<span>&nbsp;</span>")); // spacer
        return hl;
    }

}
