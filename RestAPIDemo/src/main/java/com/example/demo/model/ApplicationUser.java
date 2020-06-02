package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "application_user")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserRole> userRoles;

    public long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

}
