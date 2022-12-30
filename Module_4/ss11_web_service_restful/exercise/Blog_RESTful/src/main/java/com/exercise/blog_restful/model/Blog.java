package com.exercise.blog_restful.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String content;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date dateCreate;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(String name, String content, Category category, Date dateCreate) {
        this.name = name;
        this.content = content;
        this.category = category;
        this.dateCreate = dateCreate;
    }

    public Blog(String name, String description, Date dateCreate) {
        this.name = name;
        this.content = description;
        this.dateCreate = dateCreate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
