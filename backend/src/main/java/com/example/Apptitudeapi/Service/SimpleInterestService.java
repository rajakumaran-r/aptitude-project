package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Repository.SimpleInterestRepository;
import com.example.Apptitudeapi.model.SimpleInterest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SimpleInterestService {

    private final SimpleInterestRepository repository;

    public SimpleInterestService(SimpleInterestRepository repository) {
        this.repository = repository;
    }

    // ✅ ALL QUESTIONS
    public List<QuestionDTO> getAllSimpleInterests() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // ✅ RANDOM N QUESTIONS
    public List<QuestionDTO> getRandomSimpleInterests(int n) {
        List<SimpleInterest> all = repository.findAll();
        Collections.shuffle(all);

        return all.stream()
                .limit(n)
                .map(this::toDTO)
                .toList();
    }

    // 🔁 ENTITY → DTO
    private QuestionDTO toDTO(SimpleInterest q) {
        return new QuestionDTO(
                "simpleinterest",
                q.getQuestion(),
                List.of(q.getOptions()),
                q.getAnswer(),
                q.getExplanation()
        );
    }
}
