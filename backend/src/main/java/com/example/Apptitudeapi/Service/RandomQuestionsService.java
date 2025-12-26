package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Repository.RandomQuestionsRepository;
import com.example.Apptitudeapi.model.RandomQuestions;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class RandomQuestionsService {

    private final RandomQuestionsRepository repository;

    public RandomQuestionsService(RandomQuestionsRepository repository) {
        this.repository = repository;
    }

    // ✅ RANDOM N QUESTIONS
    public List<QuestionDTO> getRandomQuestions(int n) {
        List<RandomQuestions> all = repository.findAll();
        Collections.shuffle(all);

        return all.stream()
                .limit(n)
                .map(this::toDTO)
                .toList();
    }

    // 🔁 ENTITY → DTO
    private QuestionDTO toDTO(RandomQuestions q) {
        return new QuestionDTO(
                "random",
                q.getQuestion(),
                List.of(q.getOptions()),
                q.getAnswer(),
                q.getExplanation()
        );
    }
}
