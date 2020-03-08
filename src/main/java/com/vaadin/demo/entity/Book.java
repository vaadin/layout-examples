package com.vaadin.demo.entity;

public class Book {

    private String image;
    private String title;
    private String author;
    private Double price;

    public Book(String image, String title, String author, Double price) {
        this.image = image;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
