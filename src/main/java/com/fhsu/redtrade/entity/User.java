package com.fhsu.redtrade.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {


    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Basic
//    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    @Basic
//    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @Column (name="first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//    @Column (name="last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "id=" + id + ", username=" + username;
    }
}
