package com.example.insticator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

//@Entity
//@Table(name = "checkbox")
public class Checkbox implements Serializable{

    private static final long serialVersionUID = 3393110286764744883L;

//    @Id
//    @Column(name = "cid")
    private int cId;

    private String content;

    private List<String> answers;

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
