package com.entity;

import com.entity.enums.Certificate;
import com.entity.enums.Genre;
import com.entity.enums.Language;

import java.util.EnumSet;

public class Movie {

    private Integer id;
    private String title;
    private Certificate certificate;
    private Language languages;
    private EnumSet<Genre> genres;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Language getLanguages() {
        return languages;
    }

    public void setLanguages(Language languages) {
        this.languages = languages;
    }

    public EnumSet<Genre> getGenres() {
        return genres;
    }

    public void setGenres(EnumSet<Genre> genres) {
        this.genres = genres;
    }
}
