/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import database.connection.ConnectionFactory;
import domain.Admin;
import domain.MovieTheater;
import domain.UserRole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.StorageMovieTheater;

/**
 *
 * @author Milica i Nikola
 */
public class StorageDatabaseMovieTheater implements StorageMovieTheater {

    @Override
    public MovieTheater saveMovieTheater(MovieTheater movieTheater) {
        try {

            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "insert into movie_theater(name,adress) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, movieTheater.getName());
            preparedStatement.setString(2, movieTheater.getAdress());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                movieTheater.setMovieTheaterID(rs.getLong(1));
            }
            return movieTheater;
        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabaseMovieTheater.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<MovieTheater> getAllMovieTheaters() {
        try {
            List<MovieTheater> allMovieTheaters = new ArrayList();
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "select * from movie_theater order by name";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                MovieTheater m  = new MovieTheater(rs.getLong("movietheaterID"), rs.getString("name"), rs.getString("adress"));
                allMovieTheaters.add(m);
            }
            return allMovieTheaters;
        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabaseMovieTheater.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public MovieTheater updateMovieTheater(MovieTheater movieTheater) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "update movie_theater set name='"+  movieTheater.getName()+"',adress='"+movieTheater.getAdress()+"' where movietheaterid="+movieTheater.getMovieTheaterID();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            return movieTheater;
        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabaseMovieTheater.class.getName()).log(Level.SEVERE, null, ex);
        }
          return null;
    }

    @Override
    public void deleteMovieTheater(MovieTheater movieTheater) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "delete from movie_theater where movietheaterid ="+  movieTheater.getMovieTheaterID();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabaseMovieTheater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}