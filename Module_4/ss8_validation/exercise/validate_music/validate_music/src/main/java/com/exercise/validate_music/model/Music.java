package com.exercise.validate_music.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    @Column(columnDefinition = "varchar(50)")
    private String name;
    private String singer;
    private String type;
    private String song;

    public Music() {
    }

    public Music(String name, String singer, String type, String song) {
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.song = song;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
