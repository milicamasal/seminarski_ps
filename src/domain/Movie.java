/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Milica i Nikola
 */
public class Movie {

    private Long movieID;
    private String title;
    private LocalDate releasedDate;
    private List<Genre> genres;
    private String director;
    private String writer;
    private List<Actor> leadCast;
    private Long duration;
    private String synopsis;
    private User createdByAdmin;

    public Movie() {
    }

    public Long getMovieID() {
        return movieID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public User getCreatedByAdmin() {
        return createdByAdmin;
    }

    public void setCreatedByAdmin(User createdByAdmin) {
        this.createdByAdmin = createdByAdmin;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Movie(Long movieID, String title, LocalDate releasedDate, List<Genre> genres, String director, String writer, List<Actor> leadCast, Long duration, String synopsis, User createdByAdmin) {
        this.movieID = movieID;
        this.title = title;
        this.releasedDate = releasedDate;
        this.genres = genres;
        this.director = director;
        this.writer = writer;
        this.leadCast = leadCast;
        this.duration = duration;
        this.synopsis = synopsis;
        this.createdByAdmin = createdByAdmin;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public List<Actor> getLeadCast() {
        return leadCast;
    }

    public void setLeadCast(List<Actor> leadCast) {
        this.leadCast = leadCast;
    }

    @Override
    public String toString() {
        return title;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

}
