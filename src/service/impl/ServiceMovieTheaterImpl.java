/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.MovieTheater;
import java.util.List;
import service.ServiceMovieTheater;
import storage.StorageMovieTheater;
import storage.impl.database.StorageDatabaseMovieTheater;

/**
 *
 * @author Milica i Nikola
 */
public class ServiceMovieTheaterImpl implements ServiceMovieTheater {

    private final StorageMovieTheater storageMovieTheater;

    public ServiceMovieTheaterImpl() {
        storageMovieTheater = new StorageDatabaseMovieTheater();
    }

    @Override
    public MovieTheater saveMovieTheater(MovieTheater movieTheater) {
        return storageMovieTheater.saveMovieTheater(movieTheater);
    }

    @Override
    public List<MovieTheater> getAllMovieTheaters() {
        return storageMovieTheater.getAllMovieTheaters();
    }

    @Override
    public MovieTheater updateMovieTheater(MovieTheater movieTheater) {
        return storageMovieTheater.updateMovieTheater(movieTheater);
    }

    @Override
    public void deleteMovieTheater(MovieTheater movieTheater) {
        storageMovieTheater.deleteMovieTheater(movieTheater);
    }

}
