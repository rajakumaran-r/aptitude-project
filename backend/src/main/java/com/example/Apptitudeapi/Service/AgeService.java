package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.Repository.AgeRepository;
import com.example.Apptitudeapi.model.Age;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AgeService {
    public final AgeRepository ageRepository;

    @Autowired
    public AgeService(AgeRepository ageRepository) {
        this.ageRepository = ageRepository;
    }
    public List<Age> getAllAges() {
        return ageRepository.findAll();

    }

    public Age getRandomAge() {
        List<Age> allAges = ageRepository.findAll(); // Fetch all documents
        if (allAges.isEmpty()) {
            return null; // Handle case where no documents exist
        }

        Random random = new Random();
        int randomIndex = random.nextInt(allAges.size()); // Generate a random index
        return allAges.get(randomIndex);
    }

    public List<Age> getRandomNumbers(@RequestParam int n) {
        List<Age> allAges = ageRepository.findAll();
        List<Age> questions = new ArrayList<>();

        //generate n random numbers
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(allAges.size() - 1); // Random number between 0 and 99
            questions.add(allAges.get(randomNumber)) ;
        }
        return questions;
    }
}
