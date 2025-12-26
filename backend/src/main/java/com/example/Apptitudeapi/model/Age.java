package com.example.Apptitudeapi.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
@Document(collection="ages")
public class Age {

    @Id
    private String id; // Unique identifier
    private String question; // The aptitude question
    private String answer; // The correct answer
    private String explanation; // Explanation for the correct answer
    private String[] options; // Array of options

    // Default constructor
    public Age() {
    }

    // Parameterized constructor
    public Age(String id, String question, String answer, String explanation, String[] options) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.explanation = explanation;
        this.options = options;
    }

    // Getters and Setters
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

    @Override
    public String toString() {
        return "Ages{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", explanation='" + explanation + '\'' +
                ", options=" + Arrays.toString(options) +
                '}';
    }
}