package com.example.Apptitudeapi.DTO;

import java.util.List;

public class QuestionDTO {

    private String topic;
    private String question;
    private List<String> options;
    private String answer;
    private String explanation;

    // ✅ REQUIRED: No-args constructor (VERY IMPORTANT)
    public QuestionDTO() {
    }

    // ✅ All-args constructor
    public QuestionDTO(String topic,
                       String question,
                       List<String> options,
                       String answer,
                       String explanation) {
        this.topic = topic;
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.explanation = explanation;
    }

    // ✅ Getters & Setters (Jackson-friendly)

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
