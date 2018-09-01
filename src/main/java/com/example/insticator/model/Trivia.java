package com.example.insticator.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Entity
public class Trivia implements Serializable {

    private static final long serialVersionUID = 5570366015921465678L;

    private int tId;
    private String content;

    List<String> answers;

    private Integer correct;

    public Trivia(String content, List<String> answers, Integer correct) {
        this.content = content;
        this.answers = answers;
        this.correct = correct;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }
}
