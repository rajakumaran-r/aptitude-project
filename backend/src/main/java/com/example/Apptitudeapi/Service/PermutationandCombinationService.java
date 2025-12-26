package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Repository.PermutationandCombinationRepository;
import com.example.Apptitudeapi.model.PermutationandCombination;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PermutationandCombinationService {

    private final PermutationandCombinationRepository repository;

    public PermutationandCombinationService(
            PermutationandCombinationRepository repository
    ) {
        this.repository = repository;
    }

    // ✅ ALL QUESTIONS
    public List<QuestionDTO> getAllPermutationandCombinations() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // ✅ RANDOM N QUESTIONS
    public List<QuestionDTO> getRandomPermutationandCombinations(int n) {
        List<PermutationandCombination> all = repository.findAll();
        Collections.shuffle(all);

        return all.stream()
                .limit(n)
                .map(this::toDTO)
                .toList();
    }

    // 🔁 ENTITY → DTO
    private QuestionDTO toDTO(PermutationandCombination q) {
        return new QuestionDTO(
                "permutationandcombination",
                q.getQuestion(),
                List.of(q.getOptions()),
                q.getAnswer(),
                q.getExplanation()
        );
    }
}
