package com.example.insticator.model;

import com.example.insticator.model.wrappedId.TAnswerId;

import javax.persistence.*;

@Entity
@Table(name = "trivia_answer",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"tid", "uid"}))
@AssociationOverrides({
        @AssociationOverride(name = "tAnswerId.trivia",
                joinColumns = @JoinColumn(name = "tid")),
        @AssociationOverride(name = "tAnswerId.user",
                joinColumns = @JoinColumn(name = "uid")) })
public class TAnswer {

    @EmbeddedId
    private TAnswerId tAnswerId;


    @Column(name = "answer")
    private int answer;

    public TAnswer() {
    }


    public TAnswer(TAnswerId tAnswerId, int answer) {
        this.tAnswerId = tAnswerId;
        this.answer = answer;
    }

    public TAnswerId gettAnswerId() {
        return tAnswerId;
    }

    public void settAnswerId(TAnswerId tAnswerId) {
        this.tAnswerId = tAnswerId;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
