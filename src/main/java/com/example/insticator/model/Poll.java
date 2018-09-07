package com.example.insticator.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "poll")
public class Poll implements Serializable {

    private static final long serialVersionUID = -565888699339315742L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pid")
    private int pId;

    @Column(name = "content")
    private String content;

    @Column(name = "answersA")
    private String answersA;

    @Column(name = "answersB")
    private String answersB;

    @Column(name = "answersC")
    private String answersC;

    @Column(name = "answersD")
    private String answersD;

    @OneToMany(
            mappedBy = "pAnswerId.poll",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<PAnswer> tAnswers = new ArrayList<>();

    public Poll() {
    }

    public Poll(String content, String answersA, String answersB, String answersC, String answersD) {
        this.content = content;
        this.answersA = answersA;
        this.answersB = answersB;
        this.answersC = answersC;
        this.answersD = answersD;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswersA() {
        return answersA;
    }

    public void setAnswersA(String answersA) {
        this.answersA = answersA;
    }

    public String getAnswersB() {
        return answersB;
    }

    public void setAnswersB(String answersB) {
        this.answersB = answersB;
    }

    public String getAnswersC() {
        return answersC;
    }

    public void setAnswersC(String answersC) {
        this.answersC = answersC;
    }

    public String getAnswersD() {
        return answersD;
    }

    public void setAnswersD(String answersD) {
        this.answersD = answersD;
    }

    public List<PAnswer> gettAnswers() {
        return tAnswers;
    }

    public void settAnswers(List<PAnswer> tAnswers) {
        this.tAnswers = tAnswers;
    }
}
