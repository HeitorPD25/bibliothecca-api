package br.com.fiap.bibliothecca_api.model;

import java.util.Date;

public class Book {
    
    private Long id;
    private String name;
    private String category;
    private String writer;
    private Date release_date;
    
    public Book(Long id, String name, String category, String writer, Date release_date) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.writer = writer;
        this.release_date = release_date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getWriter() {
        return writer;
    }

    public Date getRelease_date() {
        return release_date;
    }

}
