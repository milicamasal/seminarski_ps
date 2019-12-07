/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Movie;
import java.util.List;
import service.ServiceMovie;
import storage.StorageMovie;
import storage.impl.database.StorageDatabaseMovie;

/**
 *
 * @author Milica i Nikola
 */
public class ServiceMovieImpl implements ServiceMovie {

    private final StorageMovie storageMovie;

    public ServiceMovieImpl() {
        storageMovie = new StorageDatabaseMovie();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        try {
            return storageMovie.saveMovie(movie);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public List<Movie> getAllMovies() {
        return storageMovie.getAllMovies();
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return storageMovie.updateMovie(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        storageMovie.deleteMovie(movie);
    }

    @Override
    public Movie getMovieById(Long movieid) {
        return storageMovie.getMovieById(movieid);
    }

    

}
