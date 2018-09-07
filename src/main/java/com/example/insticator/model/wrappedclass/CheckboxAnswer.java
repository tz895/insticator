package com.example.insticator.model.wrappedclass;

import java.util.ArrayList;
import java.util.List;

public class CheckboxAnswer {
    private List<String> answers;

    public CheckboxAnswer() {
        this.answers = new ArrayList<>();
    }

    public CheckboxAnswer(List<String> answers) {
        this.answers = answers;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void add(String s) {
        this.answers.add(s);
    }
}
