package com.example.Apptitudeapi.Repository;

import com.example.Apptitudeapi.model.SimpleInterest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SimpleInterestRepository extends MongoRepository<SimpleInterest,String> {
}
