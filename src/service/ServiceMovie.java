/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Movie;
import java.util.List;

/**
 *
 * @author Milica i Nikola
 */
public interface ServiceMovie {

    public Movie saveMovie(Movie movie);

    public List<Movie> getAllMovies();

    public Movie updateMovie(Movie movie);

    public void deleteMovie(Movie movie);
    
    public Movie getMovieById(Long movieid);
    
}
