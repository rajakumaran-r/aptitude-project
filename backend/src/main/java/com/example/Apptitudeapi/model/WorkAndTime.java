package com.example.Apptitudeapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "workandtime")
public class WorkAndTime {

    @Id
    private String id;

    private String question;
    private String answer;
    private String explanation;
    private String[] options;

    // ✅ REQUIRED
    public WorkAndTime() {}

    public WorkAndTime(String id, String question,
                       String answer, String explanation,
                       String[] options) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.explanation = explanation;
        this.options = options;
    }

    public String getId() { return id; }
    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
    public String getExplanation() { return explanation; }
    public String[] getOptions() { return options; }

    public void setId(String id) { this.id = id; }
    public void setQuestion(String question) { this.question = question; }
    public void setAnswer(String answer) { this.answer = answer; }
    public void setExplanation(String explanation) { this.explanation = explanation; }
    public void setOptions(String[] options) { this.options = options; }
}
