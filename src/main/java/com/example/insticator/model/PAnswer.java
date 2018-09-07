package com.example.insticator.model;

import com.example.insticator.model.wrappedId.PAnswerId;

import javax.persistence.*;

@Entity
@Table(name = "poll_answer",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"pid", "uid"}))
@AssociationOverrides({
        @AssociationOverride(name = "pAnswerId.poll",
                joinColumns = @JoinColumn(name = "pid")),
        @AssociationOverride(name = "pAnswerId.user",
                joinColumns = @JoinColumn(name = "uid")) })
public class PAnswer {

    @EmbeddedId
    private PAnswerId pAnswerId;

    @Column(name = "answer")
    private String answer;

    public PAnswer() {
    }

    public PAnswer(PAnswerId pAnswerId, String answer) {
        this.pAnswerId = pAnswerId;
        this.answer = answer;
    }

    public PAnswerId getpAnswerId() {
        return pAnswerId;
    }

    public void setpAnswerId(PAnswerId pAnswerId) {
        this.pAnswerId = pAnswerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
