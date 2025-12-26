package com.example.Apptitudeapi.Repository;

import com.example.Apptitudeapi.model.Age;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AgeRepository extends MongoRepository<Age, String> {
}
