package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Repository.MixtureandAlligationRepository;
import com.example.Apptitudeapi.model.MixtureandAlligation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MixtureandAlligationService {

    private final MixtureandAlligationRepository repository;
    private final Random random = new Random();

    public MixtureandAlligationService(MixtureandAlligationRepository repository) {
        this.repository = repository;
    }

    // ✅ ALL QUESTIONS
    public List<QuestionDTO> getAllMixtureandAlligations() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // ✅ ONE RANDOM
    public QuestionDTO getRandomMixtureandAlligation() {
        List<MixtureandAlligation> list = repository.findAll();
        if (list.isEmpty()) return null;

        return toDTO(list.get(random.nextInt(list.size())));
    }

    // ✅ N RANDOM
    public List<QuestionDTO> getRandomMixtureandAlligations(int n) {
        List<MixtureandAlligation> list = repository.findAll();
        List<QuestionDTO> result = new ArrayList<>();

        if (list.isEmpty()) return result;
        if (n > list.size()) n = list.size();

        for (int i = 0; i < n; i++) {
            result.add(toDTO(list.get(random.nextInt(list.size()))));
        }
        return result;
    }

    // 🔥 ENTITY → DTO MAPPER
    private QuestionDTO toDTO(MixtureandAlligation q) {
        return new QuestionDTO(
                "mixtureandalligation",
                q.getQuestion(),
                List.of(q.getOptions()), // String[] → List<String>
                q.getAnswer(),
                q.getExplanation()
        );
    }
}
