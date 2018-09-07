package com.example.insticator.model.wrappedId;

import com.example.insticator.model.Poll;
import com.example.insticator.model.User;

import javax.persistence.ManyToOne;
import java.io.Serializable;

public class PAnswerId implements Serializable {

    private static final long serialVersionUID = -3539389114855516455L;

    @ManyToOne
    private Poll poll;

    @ManyToOne
    private User user;

    public PAnswerId() {
    }

    public PAnswerId(Poll poll, User user) {
        this.poll = poll;
        this.user = user;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
