package com.example.insticator.model;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matric")
public class Matric implements Serializable {

    private static final long serialVersionUID = -2670765923542233741L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mid")
    private int mId;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    @ElementCollection
    @CollectionTable(name = "matricRowOption", joinColumns = @JoinColumn(name = "matric_id"))
    @OrderColumn
    private List<String> rowOptions = new ArrayList<>();


    @ElementCollection
    @CollectionTable(name = "matricColOption", joinColumns = @JoinColumn(name = "matric_id"))
    @OrderColumn
    private List<String> colOptions = new ArrayList<>();

    public Matric() {
    }

    public Matric(String content, String title, List<String> rowOptions, List<String> colOptions) {
        this.content = content;
        this.title = title;
        this.rowOptions = rowOptions;
        this.colOptions = colOptions;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getRowOptions() {
        return rowOptions;
    }

    public void setRowOptions(List<String> rowOptions) {
        this.rowOptions = rowOptions;
    }

    public List<String> getColOptions() {
        return colOptions;
    }

    public void setColOptions(List<String> colOptions) {
        this.colOptions = colOptions;
    }
}
