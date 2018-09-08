package com.example.insticator.model;

import com.example.insticator.model.wrappedId.MAnswerId;

import javax.persistence.*;

@Entity
@Table(name = "matric_answer",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"mid", "uid"}))
@AssociationOverrides({
        @AssociationOverride(name = "mAnswerId.matric",
                joinColumns = @JoinColumn(name = "mid")),
        @AssociationOverride(name = "mAnswerId.user",
                joinColumns = @JoinColumn(name = "uid")) })
public class MAnswer {

    @EmbeddedId
    private MAnswerId mAnswerId;

    @Column(name = "answer")
    private String answer;

    public MAnswer() {
    }

    public MAnswer(MAnswerId mAnswerId, String answer) {
        this.mAnswerId = mAnswerId;
        this.answer = answer;
    }

    public MAnswerId getmAnswerId() {
        return mAnswerId;
    }

    public void setmAnswerId(MAnswerId mAnswerId) {
        this.mAnswerId = mAnswerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
