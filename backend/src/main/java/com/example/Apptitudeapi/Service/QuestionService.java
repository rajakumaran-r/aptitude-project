package com.example.Apptitudeapi.Service;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.model.Question;
import com.example.Apptitudeapi.Repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public List<QuestionDTO> getByTopic(String topic) {

        return repository.findByTopicIgnoreCase(topic)
                .stream()
                .map(q -> new QuestionDTO(
                        q.getTopic(),
                        q.getQuestion(),
                        q.getOptions(),
                        q.getAnswer(),
                        q.getExplanation()
                ))
                .toList();
    }
}
