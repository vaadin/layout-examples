package com.vaadin.demo.views;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("horizontal")
@PageTitle("HorizontalLayout Examples")
public class HorizontalExamplesView extends VerticalLayout {

    public HorizontalExamplesView() {
        setSpacing(true);
        setPadding(true);

        add(new H2("Horizontal Layout Examples"));

        add(new Text("Each layout has a width of 100%, and a gray background color for better visibility."));

        category("Margin and Padding");

        HorizontalLayout layout = createLayout("Basic example with default settings");
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

        category("Size and Scrolling");

        layout = createLayout("Height set to 150px (with padding)");
        layout.setPadding(true);
        layout.setHeight("150px");
        layout.add(button("Button one"), button("Button two"));

        layout = createLayout("Aligning all items");
        layout.setPadding(true);
        layout.setHeight("150px");
        layout.setAlignItems(Alignment.END);
        layout.add(button("Button one"), button("Button two"));

        layout = createLayout("Aligning individual items");
        layout.setPadding(true);
        layout.setHeight("150px");
        Button button = button("Align start");
        layout.add(button);
        layout.setVerticalComponentAlignment(Alignment.START, button);
        button = button("Align center");
        layout.add(button);
        layout.setVerticalComponentAlignment(Alignment.CENTER, button);
        button = button("Align end");
        layout.add(button);
        layout.setVerticalComponentAlignment(Alignment.END, button);
        button = button("Strech");
        layout.add(button);
        button.setHeight("auto");

        layout = createLayout("Enable scrolling");
        layout.setPadding(true);
        layout.add(button("Button"), button("Button"), button("Button"), button("Button"), button("Button"), button("Button"), button("Button"),
                button("Button"), button("Button"), button("Button"), button("Button"), button("Button"));
        button = button("Mushroom");
        button.getStyle().set("flex-shrink", "0"); // necessary so that the layout doesn't try to shrink the button. The final
                                                   // button doesn't have this addition and demonstrates the issue.
        layout.add(button);
        button = button("Mushroom");
        layout.add(button);
        layout.getStyle().set("overflow", "scroll");

        category("Positioning");

        layout = createLayout("Expanding one component");
        layout.setPadding(true);
        button = button("Button one");
        layout.add(button, button("Button two"));
        layout.setFlexGrow(1, button); // this expands the button

        layout = createLayout("Expanding both components");
        layout.setPadding(true);
        layout.addAndExpand(button("Button one"), button("Button two")); // adds and flex-grows both components

        layout = createLayout("Split positioning (without expanding either component)");
        layout.setPadding(true);
        button = button("Button two");
        button.getStyle().set("margin-left", "auto"); // expands the empty space left of button two
        layout.add(button("Button one"), button);

        layout = createLayout("Advanced split positioning 1");
        layout.setPadding(true);
        button = button("Button two");
        button.getStyle().set("margin-right", "auto");// expands the empty space right of button two
        layout.add(button("Button one"), button, button("Button three"));

        layout = createLayout("Advanced split positioning 2");
        layout.setPadding(true);
        button = button("Button two");
        button.getStyle().set("margin-left", "auto");// expands the empty space left of button two
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

    private HorizontalLayout createLayout(String caption) {
        HorizontalLayout hl = new HorizontalLayout();
        hl.setWidthFull();
        hl.getStyle().set("background-color", "#dddddd");
        add(new Text(caption));
        add(hl);
        add(new Html("<span>&nbsp;</span>")); // spacer
        return hl;
    }

}
