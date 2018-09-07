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

    @OneToMany(
            mappedBy = "pAnswerId.user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<PAnswer> pAnswers = new ArrayList<>();

    @OneToMany(
            mappedBy = "cAnswerId.user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<CAnswer> cAnswers = new ArrayList<>();

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

    public List<PAnswer> getpAnswers() {
        return pAnswers;
    }

    public void setpAnswers(List<PAnswer> pAnswers) {
        this.pAnswers = pAnswers;
    }

    public List<CAnswer> getcAnswers() {
        return cAnswers;
    }

    public void setcAnswers(List<CAnswer> cAnswers) {
        this.cAnswers = cAnswers;
    }
}
