/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Movie;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Milica i Nikola
 */
public interface StorageMovie {
      Movie saveMovie(Movie movie) throws SQLException;

    public List<Movie> getAllMovies();
    
    Movie updateMovie(Movie movie);
}
