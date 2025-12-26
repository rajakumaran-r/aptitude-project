package com.example.Apptitudeapi.Repository;

import com.example.Apptitudeapi.model.WorkAndTime;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkAndTimeRepository extends MongoRepository<WorkAndTime,String> {
}
