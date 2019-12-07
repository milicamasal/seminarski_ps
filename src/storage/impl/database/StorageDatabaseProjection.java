/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import controller.Controller;
import database.connection.ConnectionFactory;
import domain.Projection;
import domain.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.StorageProjection;

/**
 *
 * @author Milica i Nikola
 */
public class StorageDatabaseProjection implements StorageProjection {

    /*LocalDate locald = LocalDate.of(1967, 06, 22);
Date date = Date.valueOf(locald); // Magic happens here!
r.setDateOfBirth(date);
    
    ---------
    Date date = r.getDate();
LocalDate localD = date.toLocalDate();
     */

 /*localtime to sql time
    
    LocalTime now = LocalTime.now();
 
        Time time = Time.valueOf( now );
         
        System.out.println(time);
    -----
    sql to local time  java.sql.Time sqlTime = new Time(new Date().getTime());
         
        //Get LocalTime from SQL time
        LocalTime localTime = sqlTime.toLocalTime();
         
        System.out.println( localTime );    //14:00:33
     */
    @Override
    public Projection saveProjection(Projection projection) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String query = "insert into projection(movieid,time,date,screen,theaterid,created_by_employeeid)"
                    + " values(" + projection.getMovie().getMovieID() + ",'" + Time.valueOf(projection.getTime()) + "',"
                    + "'" + Date.valueOf(projection.getDate()) + "','" + projection.getScreen() + "'," + projection.getTheater().getMovieTheaterID()
                    + "," + projection.getCreatedByEmployee().getUserID() + ")";
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                projection.setProjectionID(rs.getLong(1));
            }
            return projection;
        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabaseProjection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Projection> getAllProjections() {
        try {
            List<Projection> allProjections = new ArrayList();
            Connection connection = ConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String query = "select movieid,projectionid,time,date,screen,theaterid from projection where created_by_employeeid=" + ((User) Controller.getInstance().getMap().get("current_employee")).getUserID();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Projection projection = new Projection();

                projection.setProjectionID(rs.getLong("projectionid"));
                projection.setDate(rs.getDate("date").toLocalDate());
                projection.setTime(rs.getTime("time").toLocalTime());
                projection.setScreen(rs.getString("screen"));
                projection.setMovie(Controller.getInstance().getMovieById(rs.getLong("movieid")));
                projection.setTheater(Controller.getInstance().getMovieTheaterById(rs.getLong("theaterid")));
                projection.setCreatedByEmployee((User) Controller.getInstance().getMap().get("current_employee"));

                allProjections.add(projection);
            }
            return allProjections;

        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabaseProjection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Projection updateProjection(Projection projection) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String query = "update projection set date='" + Date.valueOf(projection.getDate())
                    + "',time='" + Time.valueOf(projection.getTime()) + "',screen='" + projection.getScreen()
                    + "',theaterid=" + projection.getTheater().getMovieTheaterID() + ",movieid="
                    + projection.getMovie().getMovieID() + ",created_by_employeeid=" + ((User) Controller.getInstance().getMap().get("current_employee")).getUserID()
                    + " where projectionid=" + projection.getProjectionID();
            
            statement.executeUpdate(query);
            return projection;
        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabaseProjection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
