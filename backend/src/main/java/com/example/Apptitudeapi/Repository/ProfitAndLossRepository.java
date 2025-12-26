package com.example.Apptitudeapi.Repository;

import com.example.Apptitudeapi.model.ProfitAndLoss;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProfitAndLossRepository extends MongoRepository<ProfitAndLoss, String> {
}
