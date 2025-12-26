package com.example.Apptitudeapi.Repository;

import com.example.Apptitudeapi.model.RandomQuestions;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RandomQuestionsRepository extends MongoRepository<RandomQuestions,String> {
}
