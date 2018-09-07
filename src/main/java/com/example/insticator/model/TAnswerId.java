package com.example.insticator.model;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

public class TAnswerId implements Serializable {

    private static final long serialVersionUID = 5570377015921465678L;

    @ManyToOne
    private Trivia trivia;

    @ManyToOne
    private User user;

    public TAnswerId() {
    }

    public TAnswerId(Trivia trivia, User user) {
        this.trivia = trivia;
        this.user = user;
    }

    public Trivia getTrivia() {
        return trivia;
    }

    public void setTrivia(Trivia trivia) {
        this.trivia = trivia;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
