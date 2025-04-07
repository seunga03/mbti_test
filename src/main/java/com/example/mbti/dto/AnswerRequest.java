package com.example.mbti.dto;

import java.util.List;

public class AnswerRequest {
    private List<Integer> answers;

    public List<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }
}