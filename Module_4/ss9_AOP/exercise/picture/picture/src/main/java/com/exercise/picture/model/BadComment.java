package com.exercise.picture.model;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BadComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String author;
    private String feedback;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateComment;

    public BadComment() {
    }

    public BadComment(String author, String feedback, Date dateComment) {
        this.author = author;
        this.feedback = feedback;
        this.dateComment = dateComment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getDateComment() {
        return dateComment;
    }

    public void setDateComment(Date dateComment) {
        this.dateComment = dateComment;
    }

    @Override
    public String toString() {
        return "BadComment{" +
                "author='" + author + '\'' +
                ", feedback='" + feedback + '\'' +
                ", dateComment=" + dateComment +
                '}';
    }
}
