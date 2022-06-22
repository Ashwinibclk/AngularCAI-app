
package com.example.postgresql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.http.ResponseEntity;

@Entity

@Table(name="user",schema="")
public class user {
    public user(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="username")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="role")
    private String role;
    @Column(name="isactive")
    private String isactive;

    

    public user(Long id, String username, String email, String role,Boolean isactive) {
        this.id = id;
        this.username = username;
        this.email = email;
       this.role = role;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }

    public String getisactive() {
        return isactive;
    }

    public void setisactive(String isactive) {
        this.isactive = isactive;
    }
}