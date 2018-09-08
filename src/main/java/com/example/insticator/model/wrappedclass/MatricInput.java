package com.example.insticator.model.wrappedclass;

import java.util.ArrayList;
import java.util.List;

public class MatricInput {
    private int mid;

    private String content;

    private String title;

    private String rowOption1;

    private String rowOption2;

    private String rowOption3;

    private String rowOption4;

    private String rowOption5;

    private String colOption1;

    private String colOption2;

    private String colOption3;

    private String colOption4;

    private String colOption5;

    public MatricInput() {
    }


    public String getContent() {
        return content;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
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

    public String getRowOption1() {
        return rowOption1;
    }

    public void setRowOption1(String rowOption1) {
        this.rowOption1 = rowOption1;
    }

    public String getRowOption2() {
        return rowOption2;
    }

    public void setRowOption2(String rowOption2) {
        this.rowOption2 = rowOption2;
    }

    public String getRowOption3() {
        return rowOption3;
    }

    public void setRowOption3(String rowOption3) {
        this.rowOption3 = rowOption3;
    }

    public String getRowOption4() {
        return rowOption4;
    }

    public void setRowOption4(String rowOption4) {
        this.rowOption4 = rowOption4;
    }

    public String getRowOption5() {
        return rowOption5;
    }

    public void setRowOption5(String rowOption5) {
        this.rowOption5 = rowOption5;
    }

    public String getColOption1() {
        return colOption1;
    }

    public void setColOption1(String colOption1) {
        this.colOption1 = colOption1;
    }

    public String getColOption2() {
        return colOption2;
    }

    public void setColOption2(String colOption2) {
        this.colOption2 = colOption2;
    }

    public String getColOption3() {
        return colOption3;
    }

    public void setColOption3(String colOption3) {
        this.colOption3 = colOption3;
    }

    public String getColOption4() {
        return colOption4;
    }

    public void setColOption4(String colOption4) {
        this.colOption4 = colOption4;
    }

    public String getColOption5() {
        return colOption5;
    }

    public void setColOption5(String colOption5) {
        this.colOption5 = colOption5;
}

    public List<String> getRowOptions() {
        List<String> list = new ArrayList<>();
        if(rowOption1 != null && rowOption1.length() != 0) {
            list.add(rowOption1);
        }
        if(rowOption2 != null && rowOption2.length() != 0) {
            list.add(rowOption2);
        }
        if(rowOption3 != null && rowOption3.length() != 0) {
            list.add(rowOption3);
        }
        if(rowOption4 != null && rowOption4.length() != 0) {
            list.add(rowOption4);
        }
        if(rowOption5 != null && rowOption5.length() != 0) {
            list.add(rowOption5);
        }
        return list;
    }

    public List<String> getColOptions() {
        List<String> list = new ArrayList<>();
        if(colOption1 != null && colOption1.length() != 0) {
            list.add(colOption1);
        }
        if(colOption2 != null && colOption2.length() != 0) {
            list.add(colOption2);
        }
        if(colOption3 != null && colOption3.length() != 0) {
            list.add(colOption3);
        }
        if(colOption4 != null && colOption4.length() != 0) {
            list.add(colOption4);
        }
        if(colOption5 != null && colOption5.length() != 0) {
            list.add(colOption5);
        }
        return list;
    }

    public void set(String content, String title,List<String> rows,List<String> cols) {
        this.content = content;
        this.title = title;

        for(String row : rows) {
            if(this.rowOption1 == null) {
                this.rowOption1 = row;
            }
            else if(this.rowOption2 == null) {
                this.rowOption2 = row;
            }
            else if(this.rowOption3 == null) {
                this.rowOption3 = row;
            }
            else if(this.rowOption4 == null) {
                this.rowOption4 = row;
            }
            else {
                this.rowOption5 = row;
            }
        }

        for(String col : cols) {
            if(this.colOption1 == null) {
                this.colOption1 = col;
            }
            else if(this.colOption2 == null) {
                this.colOption2 = col;
            }
            else if(this.rowOption3 == null) {
                this.colOption3 = col;
            }
            else if(this.colOption4 == null) {
                this.colOption4 = col;
            }
            else {
                this.colOption5 = col;
            }
        }
    }
}
