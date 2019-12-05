/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Milica i Nikola
 */
public class ConnectionFactory {

    String driver = "";
    String url = "";
    String dbusername = "";
    String dbpassword = "";
    private Connection connection;
    private static ConnectionFactory instance;

    private ConnectionFactory() throws SQLException {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            dbusername = prop.getProperty("dbusername");
            dbpassword = prop.getProperty("dbpassword");
        } catch (IOException ex) {
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {

                }
            }
        }

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, dbusername, dbpassword);
//            connection.setAutoCommit(false); 
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionFactory getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    void readConfigProperties() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            dbusername = prop.getProperty("dbusername");
            dbpassword = prop.getProperty("dbpassword");
        } catch (IOException ex) {
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
