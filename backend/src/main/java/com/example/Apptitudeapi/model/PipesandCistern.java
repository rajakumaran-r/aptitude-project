package com.example.Apptitudeapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pipesandcisterns")
public class PipesandCistern {

    @Id
    private String id;
    private String question;
    private String answer;
    private String explanation;
    private String[] options;

    // ✅ REQUIRED no-args constructor
    public PipesandCistern() {
    }

    // ✅ All-args constructor
    public PipesandCistern(String id,
                           String question,
                           String answer,
                           String explanation,
                           String[] options) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.explanation = explanation;
        this.options = options;
    }

    // ✅ Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}
