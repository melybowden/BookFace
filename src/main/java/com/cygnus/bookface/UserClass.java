package com.cygnus.bookface;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserClass")
public class UserClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "loggedin")
    private boolean loggedin;

    public UserClass(){
        this.username = null;
        this.password=null;
        this.loggedin=false;


    }

    public UserClass(String username, String password){
        this.username = username;
        this.password = password;
        this.loggedin = false;
    }

    public UserClass(UserClass other, Long id){
        this.username = other.getUsername();
        this.password = other.getPassword();
        this.id = id;
        this.loggedin = false;
    }

    public Long getID(){
        return this.id;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public boolean getLoggedin(){
        return this.loggedin;
    }

    public void setLoggedin(boolean loggedin){
        this.loggedin = loggedin;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, username, password, loggedin);
    }

    @Override
    public boolean equals (Object o){
        if (this==o){
            return true;
        }
        if (!(o instanceof UserClass)){
            return false;
        }
        UserClass u = (UserClass) o;
        return Objects.equals(username, u.username)&&Objects.equals(password, u.password);

    }

}