package com.dw.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class BoardDto {
    private long id;
    @NotBlank
    private String author;
    @NotBlank
    private String title;
    @NotBlank
    private String text;

    public BoardDto() {
    }

    public BoardDto(long id, String author, String title, String text) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
