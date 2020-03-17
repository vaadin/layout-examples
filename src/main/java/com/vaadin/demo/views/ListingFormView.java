package com.vaadin.demo.views;

import com.vaadin.demo.entity.Book;
import com.vaadin.demo.service.BookService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import java.util.List;

@Route("listing")
public class ListingFormView extends VerticalLayout {

    public ListingFormView() {
        setSizeFull();

        Component header = createHeader();
        Component filter = createFilter();

        VerticalLayout booksLayout = new VerticalLayout();
        booksLayout.setWidth("70%");

        List<Book> books = BookService.fetchAll();
        for (Book book : books) {
            booksLayout.add(createBookComponent(book.getImage(),
                    book.getTitle(), book.getAuthor(), book.getPrice()));
            booksLayout.add(new Hr());
        }

        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.add(filter, booksLayout);
        add(header, mainLayout);
    }

    private Component createFilter() {
        VerticalLayout layout = new VerticalLayout();
        layout.setWidth("30%");
        layout.setPadding(false);
        layout.getStyle().set("background-color", "#F5F5F5");
        layout.getElement().getStyle().set("flex-grow", "1");

        Span formatSpan = new Span("Format");
        formatSpan.setWidthFull();
        formatSpan.getStyle().set("text-align", "center");
        formatSpan.getStyle().set("background-color", "#D5D8DC");

        RouterLink paperback = new RouterLink("Paperback",
                ListingFormView.class);
        RouterLink hardback = new RouterLink("Hardback", ListingFormView.class);
        RouterLink audio = new RouterLink("Audio", ListingFormView.class);
        layout.add(formatSpan, hardback, paperback, audio);

        Span priceSpan = new Span("Price");
        priceSpan.setWidthFull();
        priceSpan.getStyle().set("text-align", "center");
        priceSpan.getStyle().set("background-color", "#D5D8DC");

        RouterLink price1 = new RouterLink("5$-10$", ListingFormView.class);
        RouterLink price2 = new RouterLink("10$-20$", ListingFormView.class);
        RouterLink price3 = new RouterLink("20$-50$", ListingFormView.class);
        RouterLink price4 = new RouterLink("Over 50$", ListingFormView.class);

        layout.add(priceSpan, price1, price2, price3, price4);

        Span authorSpan = new Span("Author");
        authorSpan.setWidthFull();
        authorSpan.getStyle().set("text-align", "center");
        authorSpan.getStyle().set("background-color", "#D5D8DC");

        RouterLink author1 = new RouterLink("Vaadin", ListingFormView.class);
        RouterLink author2 = new RouterLink("Vaadin team",
                ListingFormView.class);
        RouterLink author3 = new RouterLink("Alejandro Duarte",
                ListingFormView.class);
        RouterLink author4 = new RouterLink("Marko Grönroos",
                ListingFormView.class);

        layout.add(authorSpan, author1, author2, author3, author4);
        return layout;
    }

    private Component createHeader() {
        MenuBar menuBar = new MenuBar();
        menuBar.getStyle().set("flex-grow", "1");
        menuBar.addItem("Today's Deals");
        menuBar.addItem("Help");
        menuBar.addItem("Registry");

        // This HorizontalLayout contains the menuBar, searchTextField and
        // searchButton.
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setWidthFull();
        TextField searchTextField = new TextField();
        searchTextField.getStyle().set("overflow", "auto");
        searchTextField.setPlaceholder("Search");
        searchTextField.setValue("Vaadin");
        Button searchButton = new Button("Search");
        searchButton.getStyle().set("overflow", "auto");
        headerLayout.add(menuBar, searchTextField, searchButton);
        headerLayout.getStyle().set("background-color", "#F8F8F8");
        headerLayout.getStyle().set("flex-shrink", "0");
        return headerLayout;
    }

    private Component createBookComponent(String imageAddress, String title,
            String author, double price) {
        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.getStyle().set("flex-shrink", "0");
        Image image = new Image(imageAddress, "");
        image.setWidth("30%");
        image.setHeight("40%");

        VerticalLayout itemLayout = new VerticalLayout();
        H3 titleComponent = new H3(title);
        Span authorComponent = new Span("by " + author);
        Span priceComponent = new Span("$ " + price);
        itemLayout.add(titleComponent, authorComponent, priceComponent);

        mainLayout.add(image, itemLayout);
        return mainLayout;
    }
}
