/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import database.connection.ConnectionFactory;
import domain.Employee;
import domain.User;
import domain.UserRole;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.StorageUser;

/**
 *
 * @author Milica i Nikola
 */
public class StorageDatabaseUser implements StorageUser {

    @Override
    public List<User> getAllUsers() {
        try {
            List<User> allUsers = new ArrayList();
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "select * from user";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                User user = new User(rs.getLong("userid"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("username"), rs.getString("password"), UserRole.valueOf(rs.getString("userrole")));
                allUsers.add(user);
            }

            return allUsers;
        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabaseUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();

            String query = "insert into user(firstname,lastname,username,password,userrole,movietheaterid) values('"
                    + employee.getFirstName() + "','" + employee.getLastName() + "','" + employee.getUsername() + "','" + employee.getPassword()
                    + "','" + String.valueOf(employee.getUserRole()) + "'," + employee.getMovieTheater().getMovieTheaterID() + ")";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                employee.setUserID(rs.getLong(1));
            }
            return employee;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String query = "update user set firstname='" + employee.getFirstName() + "',lastname='" + employee.getLastName()
                    + "',username='" + employee.getUsername() + "',password='" + employee.getPassword() + "',movietheaterid="
                    + employee.getMovieTheater().getMovieTheaterID() + "  where userid=" + employee.getUserID();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employee;
    }

}
