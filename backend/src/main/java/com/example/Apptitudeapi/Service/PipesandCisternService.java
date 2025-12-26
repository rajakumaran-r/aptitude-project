package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.Repository.PipesandCisternRepository;
import com.example.Apptitudeapi.model.PipesandCistern;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PipesandCisternService {

    private final PipesandCisternRepository repository;

    public PipesandCisternService(PipesandCisternRepository repository) {
        this.repository = repository;
    }

    public List<PipesandCistern> getAllPipesandCisterns() {
        return repository.findAll();
    }

    public PipesandCistern getRandomPipesandCistern() {
        List<PipesandCistern> all = repository.findAll();
        if (all.isEmpty()) return null;
        return all.get(new Random().nextInt(all.size()));
    }

    public List<PipesandCistern> getRandomPipesandCisterns(int n) {
        List<PipesandCistern> all = repository.findAll();
        List<PipesandCistern> result = new ArrayList<>();

        if (all.isEmpty()) return result;

        Random random = new Random();
        int limit = Math.min(n, all.size());

        for (int i = 0; i < limit; i++) {
            result.add(all.get(random.nextInt(all.size())));
        }
        return result;
    }
}
