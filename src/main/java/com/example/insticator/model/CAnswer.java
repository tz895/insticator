package com.example.insticator.model;

import com.example.insticator.model.wrappedId.CAnswerId;

import javax.persistence.*;

@Entity
@Table(name = "checkbox_answer",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"cid", "uid"}))
@AssociationOverrides({
        @AssociationOverride(name = "cAnswerId.checkbox",
                joinColumns = @JoinColumn(name = "cid")),
        @AssociationOverride(name = "cAnswerId.user",
                joinColumns = @JoinColumn(name = "uid")) })
public class CAnswer {
    @EmbeddedId
    private CAnswerId cAnswerId;

    @Column(name = "answer")
    private String answer;

    public CAnswer() {
    }

    public CAnswer(CAnswerId cAnswerId, String answer) {
        this.cAnswerId = cAnswerId;
        this.answer = answer;
    }

    public CAnswerId getcAnswerId() {
        return cAnswerId;
    }

    public void setcAnswerId(CAnswerId cAnswerId) {
        this.cAnswerId = cAnswerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
