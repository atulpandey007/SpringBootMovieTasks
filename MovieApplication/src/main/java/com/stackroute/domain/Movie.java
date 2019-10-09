package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Movie {
    @Id
    private int id;
    private String title;
    private String language;
    private String release_date;


    public Movie(int id, String title, String language, String release_date) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.release_date = release_date;
    }

    public Movie() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", release_date='" + release_date + '\'' +
                '}';
    }
}