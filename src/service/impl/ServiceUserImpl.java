/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Employee;
import domain.User;
import java.util.List;
import javax.swing.JOptionPane;
import service.ServiceUser;
import storage.StorageUser;
import storage.impl.database.StorageDatabaseUser;

/**
 *
 * @author Milica i Nikola
 */
public class ServiceUserImpl implements ServiceUser {

    private final StorageUser storageUser;

    public ServiceUserImpl() {
        storageUser = new StorageDatabaseUser();
    }

    @Override
    public List<User> getAllUsers() {
        return storageUser.getAllUsers();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        int f = 1;//nema ga
        for (User user : getAllUsers()) {
            if (employee.getUsername().equals(user.getUsername())) {
                JOptionPane.showMessageDialog(null, "Username " + employee.getUsername() + " already exists!");
                f = 0;
            }
        }

        if (f == 1) {
            return storageUser.saveEmployee(employee);
        } else {
            return null;
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return storageUser.updateEmployee(employee);
    }

}
