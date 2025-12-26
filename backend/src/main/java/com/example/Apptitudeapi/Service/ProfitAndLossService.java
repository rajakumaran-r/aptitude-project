package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Repository.ProfitAndLossRepository;
import com.example.Apptitudeapi.model.ProfitAndLoss;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProfitAndLossService {

    private final ProfitAndLossRepository repository;

    public ProfitAndLossService(ProfitAndLossRepository repository) {
        this.repository = repository;
    }

    // ✅ ALL QUESTIONS
    public List<QuestionDTO> getAllProfitAndLosses() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // ✅ RANDOM N QUESTIONS
    public List<QuestionDTO> getRandomProfitAndLosses(int n) {
        List<ProfitAndLoss> all = repository.findAll();
        Collections.shuffle(all);

        return all.stream()
                .limit(n)
                .map(this::toDTO)
                .toList();
    }

    // 🔁 ENTITY → DTO
    private QuestionDTO toDTO(ProfitAndLoss q) {
        return new QuestionDTO(
                "profitandloss",
                q.getQuestion(),
                List.of(q.getOptions()),   // String[] → List<String>
                q.getAnswer(),
                q.getExplanation()
        );
    }
}
