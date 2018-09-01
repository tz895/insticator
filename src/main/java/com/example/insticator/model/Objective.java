package com.example.insticator.model;

import java.io.Serializable;
import java.util.List;

public class Objective implements Serializable {

    private static final long serialVersionUID = 7679561687087109451L;

    private int oId;
    private String content;

    List<String> answers;

    public Objective(String content, List<String> answers) {
        this.content = content;
        this.answers = answers;
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
}
