/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.MovieTheater;
import java.util.List;

/**
 *
 * @author Milica i Nikola
 */
public interface ServiceMovieTheater {
    MovieTheater saveMovieTheater(MovieTheater movieTheater);

    public List<MovieTheater> getAllMovieTheaters();

    public MovieTheater updateMovieTheater(MovieTheater movieTheater);

    public void deleteMovieTheater(MovieTheater movieTheater);
    
    public MovieTheater getMovieTheaterByID(Long theaterid);
}
