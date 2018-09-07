package com.example.insticator.model.wrappedId;

import com.example.insticator.model.Checkbox;
import com.example.insticator.model.User;

import javax.persistence.ManyToOne;
import java.io.Serializable;

public class CAnswerId implements Serializable {

    private static final long serialVersionUID = 6130407543136687263L;

    @ManyToOne
    private Checkbox checkbox;

    @ManyToOne
    private User user;

    public CAnswerId() {
    }

    public CAnswerId(Checkbox checkbox, User user) {
        this.checkbox = checkbox;
        this.user = user;
    }

    public Checkbox getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(Checkbox checkbox) {
        this.checkbox = checkbox;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
