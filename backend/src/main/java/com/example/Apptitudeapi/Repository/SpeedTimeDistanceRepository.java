package com.example.Apptitudeapi.Repository;

import com.example.Apptitudeapi.model.SpeedTimeDistance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpeedTimeDistanceRepository  extends MongoRepository<SpeedTimeDistance, String> {
}
