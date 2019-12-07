/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import controller.Controller;
import database.connection.ConnectionFactory;
import domain.Actor;
import domain.Admin;
import domain.Genre;
import domain.Movie;
import domain.User;
import domain.UserRole;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.StorageMovie;

/**
 *
 * @author Milica i Nikola
 */
public class StorageDatabaseMovie implements StorageMovie {

    @Override
    public Movie saveMovie(Movie movie) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "insert into movie(title,released_date,director,writer,duration,synopsis,created_by_adminid) values(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setDate(2, Date.valueOf(movie.getReleasedDate()));
            preparedStatement.setString(3, movie.getDirector());
            preparedStatement.setString(4, movie.getWriter());
            preparedStatement.setLong(5, movie.getDuration());
            preparedStatement.setString(6, movie.getSynopsis());
            preparedStatement.setLong(7, ((User) Controller.getInstance().getMap().get("current_admin")).getUserID());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                Long id = rs.getLong(1);
                movie.setMovieID(id);
            }

            query = "insert into movie_genres(movieid,genreid) values(?,?)";
            preparedStatement = connection.prepareStatement(query);
            List<Genre> genres = (List<Genre>) Controller.getInstance().getMap().get("chosen_genres");
            preparedStatement.setLong(1, movie.getMovieID());
            for (Genre genre : genres) {

                String query1 = "select genreid from genres where name='" + String.valueOf(genre) + "'";
                Statement statement = connection.createStatement();
                rs = statement.executeQuery(query1);
                if (rs.next()) {
                    preparedStatement.setLong(2, rs.getLong(1));

                    preparedStatement.executeUpdate();
                }
            }
            query = "insert into movie_actor(movieid,actorid,role) values(?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            List<Actor> actors = (List<Actor>) Controller.getInstance().getMap().get("leadcast");
            preparedStatement.setLong(1, movie.getMovieID());
            for (Actor actor : actors) {

                String query1 = "select actorid from actor where firstname='" + actor.getFirstName() + "' and lastname='" + actor.getLastName() + "'";
                Statement statement = connection.createStatement();
                rs = statement.executeQuery(query1);
                if (rs.next()) {
                    preparedStatement.setLong(2, rs.getLong(1));
                    preparedStatement.setString(3, actor.getRole());

                    preparedStatement.executeUpdate();
                }
            }

            return movie;
        } catch (SQLException ex) {
            ex.getMessage();
            ex.printStackTrace();
        } catch (NullPointerException E) {
            E.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        try {
            List<Movie> allMovies = new ArrayList();
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "select m.movieid,m.title, m.released_date,m.director,m.duration, m.writer,m.synopsis,m.created_by_adminid"
                    + " , u.firstname,u.lastname,u.username,u.password ,u.userrole from movie m join user "
                    + "u on m.created_by_adminid = u.userid";

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovieID(rs.getLong("m.movieid"));
                movie.setTitle(rs.getString("m.title"));
                movie.setReleasedDate((rs.getDate("m.released_date")).toLocalDate());
                movie.setDirector(rs.getString("m.director"));
                movie.setWriter(rs.getString("m.writer"));
                movie.setDuration(rs.getLong("m.duration"));
                movie.setSynopsis(rs.getString("m.synopsis"));
                movie.setCreatedByAdmin(new Admin(rs.getLong("m.created_by_adminid"), rs.getString("u.firstname"), rs.getString("u.lastname"), rs.getString("u.username"), rs.getString("u.password")));

                allMovies.add(movie);
            }

            //sad imas sve filmove bez listi
            query = "SELECT m.movieid,g.genreid,g.name FROM movie m"
                    + " JOIN movie_genres mg ON m.movieid=mg.movieid JOIN genres g ON mg.genreid=g.genreid";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            for (Movie movie : allMovies) {
                List<Genre> genres = new ArrayList<>();

                while (rs.next()) {
                    if (rs.getLong("m.movieid") == movie.getMovieID()) {
                        genres.add(Genre.valueOf(rs.getString("g.name")));

                    }

                }
                movie.setGenres(genres);
                rs.beforeFirst();
            }

            query = "SELECT m.movieid,a.actorid,a.firstname,a.lastname,ma.role  FROM movie m "
                    + "JOIN movie_actor ma ON m.movieid=ma.movieid JOIN actor a ON ma.actorid = a.actorid "
                    + "ORDER BY m.movieid";

            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            for (Movie movie : allMovies) {
                List<Actor> actors = new ArrayList<>();
                while (rs.next()) {
                    if (rs.getLong("m.movieid") == movie.getMovieID()) {
                        actors.add(new Actor(rs.getLong("a.actorid"), rs.getString("a.firstname"), rs.getString("a.lastname"), rs.getString("ma.role")));

                    }

                }
                movie.setLeadCast(actors);
                rs.beforeFirst();
            }
            return allMovies;
        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabaseUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Movie updateMovie(Movie movie) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "update movie set title='" + movie.getTitle() + "',released_date='" + Date.valueOf(movie.getReleasedDate()) + "',director='" + movie.getDirector()
                    + "',writer='" + movie.getWriter() + "',duration=" + movie.getDuration() + ",synopsis='" + movie.getSynopsis() + "' where movieid=" + movie.getMovieID();

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            query = "delete from movie_genres where movieid=" + movie.getMovieID();
            statement.executeUpdate(query);//obrisala sve unosim nove posle vidi nesto bolje

            query = "delete from movie_actor where movieid=" + movie.getMovieID();
            statement.executeUpdate(query);//obrisala sve unosim nove posle vidi nesto bolje

            query = "insert into movie_genres(movieid,genreid) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            List<Genre> genres = (List<Genre>) Controller.getInstance().getMap().get("chosen_genres");
            preparedStatement.setLong(1, movie.getMovieID());
            for (Genre genre : genres) {

                String query1 = "select genreid from genres where name='" + String.valueOf(genre) + "'";
                statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query1);
                if (rs.next()) {
                    preparedStatement.setLong(2, rs.getLong(1));

                    preparedStatement.executeUpdate();
                }
            }
            query = "insert into movie_actor(movieid,actorid,role) values(?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            List<Actor> actors = (List<Actor>) Controller.getInstance().getMap().get("leadcast");
            preparedStatement.setLong(1, movie.getMovieID());
            for (Actor actor : actors) {

                String query1 = "select actorid from actor where firstname='" + actor.getFirstName() + "' and lastname='" + actor.getLastName() + "'";
                statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query1);
                if (rs.next()) {
                    preparedStatement.setLong(2, rs.getLong(1));
                    preparedStatement.setString(3, actor.getRole());

                    preparedStatement.executeUpdate();
                }
            }

            return movie;
        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabaseMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void deleteMovie(Movie movie) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "delete from movie_genres where movieid=" + movie.getMovieID();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            query = "delete from movie_actor where movieid=" + movie.getMovieID();
            statement.executeUpdate(query);

            query = "delete from movie where movieid=" + movie.getMovieID();

            statement.executeUpdate(query);

        } catch (SQLException ex) {

        }
    }

    @Override
    public Movie getMovieById(Long movieid) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String query = "select * from movie where movieid = " + movieid;
            ResultSet rs = statement.executeQuery(query);

            Movie movie = new Movie();
            movie.setMovieID(movieid);
            if (rs.next()) {
                movie.setTitle(rs.getString("title"));
                movie.setReleasedDate((rs.getDate("released_date")).toLocalDate());
                movie.setDirector(rs.getString("director"));
                movie.setWriter(rs.getString("writer"));
                movie.setDuration(rs.getLong("duration"));
                movie.setSynopsis(rs.getString("synopsis"));
                movie.setCreatedByAdmin(null);
            }
            query = "SELECT m.movieid,g.genreid,g.name FROM movie m"
                    + " JOIN movie_genres mg ON m.movieid=mg.movieid JOIN genres g ON mg.genreid=g.genreid where m.movieid=" + movieid;
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            List<Genre> genres = new ArrayList<>();
            while (rs.next()) {
                genres.add(Genre.valueOf(rs.getString("g.name")));
            }
            movie.setGenres(genres);

            query = "SELECT m.movieid,a.actorid,a.firstname,a.lastname,ma.role  FROM movie m "
                    + "JOIN movie_actor ma ON m.movieid=ma.movieid JOIN actor a ON ma.actorid = a.actorid "
                    + "where m.movieid=" + movieid;

            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            List<Actor> actors = new ArrayList<>();
            while (rs.next()) {
                actors.add(new Actor(rs.getLong("a.actorid"), rs.getString("a.firstname"), rs.getString("a.lastname"), rs.getString("ma.role")));

            }
            movie.setLeadCast(actors);

            return movie;
        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabaseMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
