/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;

/**
 *
 * @author Milica i Nikola
 */
public class Projection {
    private Movie movie;
    private Long projectionID;
    private Date dateAndTime;
    private String screen;
    private Employee createdByEmployee;
    private MovieTheater theater;

    public Projection() {
    }

    public Projection(Movie movie, Long projectionID, Date dateAndTime, String screen, Employee createdByEmployee, MovieTheater theater) {
        this.movie = movie;
        this.projectionID = projectionID;
        this.dateAndTime = dateAndTime;
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

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public Employee getCreatedByEmployee() {
        return createdByEmployee;
    }

    public void setCreatedByEmployee(Employee createdByEmployee) {
        this.createdByEmployee = createdByEmployee;
    }
    
}
