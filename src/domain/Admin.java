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
public class Admin extends User{

    public Admin(Long userID, String firstName, String lastName, String username, String password) {
        super(userID, firstName, lastName,UserRole.Admin, username, password);
    }

    public Admin() {
    }

  
    
}
