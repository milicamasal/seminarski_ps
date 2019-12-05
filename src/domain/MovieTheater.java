/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;

/**
 *
 * @author Milica i Nikola
 */
public class MovieTheater {

    private Long movieTheaterID;
    private String name;
    private String adress;

    public MovieTheater(String name, String adress) {
        movieTheaterID = null;
        this.name = name;
        this.adress = adress;
    }

    public MovieTheater(Long movieTheaterID, String name, String adress) {
        this.movieTheaterID = movieTheaterID;
        this.name = name;
        this.adress = adress;
    }

    public MovieTheater() {
    }

    public Long getMovieTheaterID() {
        return movieTheaterID;
    }

    public void setMovieTheaterID(Long movieTheaterID) {
        this.movieTheaterID = movieTheaterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

  

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MovieTheater other = (MovieTheater) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.adress, other.adress)) {
            return false;
        }
        if (!Objects.equals(this.movieTheaterID, other.movieTheaterID)) {
            return false;
        }
        return true;
    }

   
    
}
