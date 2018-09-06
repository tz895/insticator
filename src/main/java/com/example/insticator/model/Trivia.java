package com.example.insticator.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trivia")
public class Trivia implements Serializable {

    private static final long serialVersionUID = 5570366015921465678L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tid")
    private int tId;

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

    @Column(name = "correct")
    private Integer correct;

    @ManyToMany(mappedBy = "trivias")
    private List<User> users = new ArrayList<>();

    public Trivia(String content, String answersA, String answersB, String answersC, String answersD, Integer correct) {
        this.content = content;
        this.answersA = answersA;
        this.answersB = answersB;
        this.answersC = answersC;
        this.answersD = answersD;
        this.correct = correct;
    }

    public Trivia() {
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
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

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
