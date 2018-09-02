package com.example.insticator.model;

import javax.persistence.Entity;

public class LearnResouce {
    String author;
    String title;
    String url;

    public LearnResouce(String author, String title, String url) {
        this.author = author;
        this.title = title;
        this.url = url;
    }
}
