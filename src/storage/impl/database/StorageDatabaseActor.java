/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import database.connection.ConnectionFactory;
import domain.Actor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.StorageActor;

/**
 *
 * @author Milica i Nikola
 */
public class StorageDatabaseActor implements StorageActor {

    @Override
    public Actor saveActor(Actor actor) {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "insert into actor(firstname,lastname) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, actor.getFirstName());
            preparedStatement.setString(2, actor.getLastName());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                Long id = rs.getLong(1);
                actor.setActorID(id);
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(StorageDatabaseActor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actor;

    } 
}