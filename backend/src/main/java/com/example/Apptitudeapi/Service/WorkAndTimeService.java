package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Repository.WorkAndTimeRepository;
import com.example.Apptitudeapi.model.WorkAndTime;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WorkAndTimeService {

    private final WorkAndTimeRepository repository;

    public WorkAndTimeService(WorkAndTimeRepository repository) {
        this.repository = repository;
    }

    // ✅ ALL QUESTIONS
    public List<QuestionDTO> getAllWorkAndTime() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // ✅ RANDOM N QUESTIONS
    public List<QuestionDTO> getRandomWorkAndTime(int n) {
        List<WorkAndTime> all = repository.findAll();
        Collections.shuffle(all);

        return all.stream()
                .limit(n)
                .map(this::toDTO)
                .toList();
    }

    // 🔁 ENTITY → DTO
    private QuestionDTO toDTO(WorkAndTime q) {
        return new QuestionDTO(
                "workandtime",
                q.getQuestion(),
                List.of(q.getOptions()),
                q.getAnswer(),
                q.getExplanation()
        );
    }
}
