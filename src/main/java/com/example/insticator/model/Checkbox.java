package com.example.insticator.model;

import java.io.Serializable;
import java.util.List;

public class Checkbox implements Serializable{

    private static final long serialVersionUID = 3393110286764744883L;

    int cid;

    String content;

    List<String> answers;

    public Checkbox(String content, List<String> answers) {
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
