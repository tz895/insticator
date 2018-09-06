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


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "answered_trivial",
            joinColumns = @JoinColumn(name = "uid"),
            inverseJoinColumns = @JoinColumn(name = "tid")
    )
    private List<Trivia> trivias = new ArrayList<>();

    public User(String username, List<Trivia> trivias) {
        this.username = username;
        this.trivias = new ArrayList<>();
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

    public List<Trivia> getTrivias() {
        return trivias;
    }

    public void setTrivias(List<Trivia> trivias) {
        this.trivias = trivias;
    }
}
