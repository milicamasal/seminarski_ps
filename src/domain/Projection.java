/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Milica i Nikola
 */
public class Projection {

    private Movie movie;
    private Long projectionID;
    private LocalDate date;
    private LocalTime time;
    private User createdByEmployee;
    private String screen;
    private MovieTheater theater;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Projection() {
    }

    public Projection(Movie movie, Long projectionID, LocalDate date, LocalTime time, String screen, User createdByEmployee, MovieTheater theater) {
        this.movie = movie;
        this.projectionID = projectionID;
        this.date = date;
        this.time = time;
        this.screen = screen;
        this.createdByEmployee = createdByEmployee;
        this.theater = theater;
    }

    public MovieTheater getTheater() {
        return theater;
    }

    public void setTheater(MovieTheater theater) {
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Long getProjectionID() {
        return projectionID;
    }

    public void setProjectionID(Long projectionID) {
        this.projectionID = projectionID;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public User getCreatedByEmployee() {
        return createdByEmployee;
    }

    public void setCreatedByEmployee(User createdByEmployee) {
        this.createdByEmployee = createdByEmployee;
    }

 

}
