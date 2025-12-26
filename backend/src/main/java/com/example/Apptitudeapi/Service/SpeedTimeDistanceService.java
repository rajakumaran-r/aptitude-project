package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Repository.SpeedTimeDistanceRepository;
import com.example.Apptitudeapi.model.SpeedTimeDistance;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SpeedTimeDistanceService {

    private final SpeedTimeDistanceRepository repository;

    public SpeedTimeDistanceService(SpeedTimeDistanceRepository repository) {
        this.repository = repository;
    }

    // ✅ ALL QUESTIONS
    public List<QuestionDTO> getAllSpeedTimeDistances() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // ✅ RANDOM N QUESTIONS
    public List<QuestionDTO> getRandomSpeedTimeDistances(int n) {
        List<SpeedTimeDistance> all = repository.findAll();
        Collections.shuffle(all);

        return all.stream()
                .limit(n)
                .map(this::toDTO)
                .toList();
    }

    // 🔁 ENTITY → DTO
    private QuestionDTO toDTO(SpeedTimeDistance q) {
        return new QuestionDTO(
                "speedtimedistance",
                q.getQuestion(),
                List.of(q.getOptions()),
                q.getAnswer(),
                q.getExplanation()
        );
    }
}
