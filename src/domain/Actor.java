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
public class Actor {
    private Long actorID;
    private String firstName;
    private String lastName;
    private String role;

    public Actor(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Actor(Long actorID, String firstName, String lastName, String role) {
        this.actorID = actorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Actor() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getActorID() {
        return actorID;
    }

    public void setActorID(Long actorID) {
        this.actorID = actorID;
    }
    
}
