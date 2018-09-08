package com.example.insticator.model.wrappedId;

import com.example.insticator.model.Matric;
import com.example.insticator.model.User;

import javax.persistence.ManyToOne;
import java.io.Serializable;

public class MAnswerId implements Serializable {

    private static final long serialVersionUID = -3495024376926656451L;

    @ManyToOne
    private Matric matric;

    @ManyToOne
    private User user;

    public MAnswerId() {
    }

    public MAnswerId(Matric matric, User user) {
        this.matric = matric;
        this.user = user;
    }

    public Matric getMatric() {
        return matric;
    }

    public void setMatric(Matric matric) {
        this.matric = matric;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
