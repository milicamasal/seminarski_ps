/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Employee;
import domain.User;
import java.util.List;

/**
 *
 * @author Milica i Nikola
 */
public interface ServiceUser {

    public List<User> getAllUsers();

    public Employee saveEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);
}
