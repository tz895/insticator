package com.example.insticator.dao;

import com.example.insticator.model.CAnswer;
import com.example.insticator.model.PAnswer;
import com.example.insticator.model.TAnswer;

public interface AnswerDao {
    void TriviaBuild(TAnswer tAnswer);
    void PollBuild(PAnswer pAnswer);
    void CheckboxBuild(CAnswer cAnswer);
}
