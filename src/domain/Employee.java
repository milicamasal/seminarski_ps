/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Milica i Nikola
 */
public class Employee extends User {

    private MovieTheater movieTheater;

    public Employee(MovieTheater movieTheater, Long userID, String firstName, String lastName,  String username, String password) {
        super(userID, firstName, lastName, UserRole.Employee, username, password);
        this.movieTheater = movieTheater;
    }

    public Employee(MovieTheater movieTheater, String firstName, String lastName, String username, String pasword) {
        super(firstName, lastName, UserRole.Employee, username, pasword);
        }

    public MovieTheater getMovieTheater() {
        return movieTheater;
    }

    public void setMovieTheater(MovieTheater movieTheater) {
        this.movieTheater = movieTheater;
    }

}
