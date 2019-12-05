/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Actor;
import domain.Employee;
import domain.Movie;
import domain.MovieTheater;
import domain.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.ServiceActor;
import service.ServiceMovie;
import service.ServiceMovieTheater;
import service.ServiceUser;
import service.impl.ServiceActorImpl;
import service.impl.ServiceMovieImpl;
import service.impl.ServiceMovieTheaterImpl;
import service.impl.ServiceUserImpl;

/**
 *
 * @author Milica i Nikola
 */
public class Controller {

    private static Controller instance;
    private final Map<String, Object> map;
    private final ServiceMovie serviceMovie;
    private final ServiceActor serviceActor;
    private final ServiceUser serviceUser;
    private final ServiceMovieTheater serviceMovieTheater;

    private Controller() {
        serviceMovie = new ServiceMovieImpl();
        serviceActor = new ServiceActorImpl();
        serviceUser = new ServiceUserImpl();
        serviceMovieTheater = new ServiceMovieTheaterImpl();

        map = new HashMap<>();

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public Movie saveMovie(Movie movie) {
        return serviceMovie.saveMovie(movie);

    }

    public Actor saveActor(Actor actor) {
        return serviceActor.saveActor(actor);
    }

    public MovieTheater saveMovieTheater(MovieTheater movieTheater) {
        return serviceMovieTheater.saveMovieTheater(movieTheater);
    }

    public Employee saveEmployee(Employee employee) {
        return serviceUser.saveEmployee(employee);
    }

    public MovieTheater updateMovieTheater(MovieTheater movieTheater) {
        return serviceMovieTheater.updateMovieTheater(movieTheater);
    }
    public Movie updateMovie(Movie movie){
    return serviceMovie.updateMovie(movie);
    }

    public Employee updateEmployee(Employee employee) {
        return serviceUser.updateEmployee(employee);
    }
    
    public void deleteMovieTheater(MovieTheater movieTheater){
        serviceMovieTheater.deleteMovieTheater(movieTheater);
    }
    

    public List<MovieTheater> getAllMovieTheaters() {
        return serviceMovieTheater.getAllMovieTheaters();
    }

    public List<User> getAllUsers() {
        return serviceUser.getAllUsers();
    }

    public List<Movie> getAllMovies() {
        return serviceMovie.getAllMovies();
    }

}
