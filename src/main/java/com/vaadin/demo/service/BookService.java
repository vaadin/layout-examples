package com.vaadin.demo.service;

import com.vaadin.demo.entity.Book;

import java.util.Arrays;
import java.util.List;

public class BookService {
    public static List<Book> fetchAll() {
        return Arrays.asList(
                new Book("images/Vaadin14.png", "Book of Vaadin 14",
                        "Vaadin team", 30.0),
                new Book("images/LearningVaadin7.png", "Learning Vaadin 7",
                        "Vaadin team", 20.0),
                new Book("images/VaadinReceipes.png", "Vaadin Receipes",
                        "Vaadin team", 10.0),
                new Book("images/Vaadin7Cookbook.png", "Vaadin 7 Cookbook",
                        "Vaadin team", 10.0),
                new Book("images/Vaadin7UIDesignByExample.png",
                        "Vaadin 7 UI Design By Example", "Vaadin team", 20.0),
                new Book("images/VaadinPortletStarter.png",
                        "Book of Vaadin (Vaadin Portlet Starter)",
                        "Vaadin team", 12.00),
                new Book("images/DataCentricApplicationsWithVaadin.png",
                        "Data-Centric Applications with Vaadin 8",
                        "Alejandro Duarte", 34.99),
                new Book("images/Vaadin 7.png", "Book of Vaadin 7",
                        "Vaadin team", 3.00),
                new Book("images/Vaadin 6.png", "Book of Vaadin 6",
                        "Vaadin team", 2.89),
                new Book("images/Vaadin 6PreviewEdition.png",
                        "Book of Vaadin 6 Preview Edition", "Vaadin team",
                        1.89));
    }
}
