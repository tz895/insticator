package com.example.insticator.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    @Column(name="uid")
    private int uId;

    @Column(name="username")
    private String username;


    @OneToMany(
            mappedBy = "tAnswerId.user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<TAnswer> tAnswers = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public User() {
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<TAnswer> gettAnswers() {
        return tAnswers;
    }

    public void settAnswers(List<TAnswer> tAnswers) {
        this.tAnswers = tAnswers;
    }
}
