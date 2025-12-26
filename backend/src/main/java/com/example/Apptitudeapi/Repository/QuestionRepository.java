package com.example.Apptitudeapi.Repository;

import com.example.Apptitudeapi.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {

    List<Question> findByTopicIgnoreCase(String topic);
}
