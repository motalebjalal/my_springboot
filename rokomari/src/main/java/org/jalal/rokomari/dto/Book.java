package org.jalal.rokomari.dto;

public class Book {
    int id;
    String name;
    String pageCount;

    public Book() {
    }

    public Book(String name, String pageCount) {
        this.name = name;
        this.pageCount = pageCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }
}
