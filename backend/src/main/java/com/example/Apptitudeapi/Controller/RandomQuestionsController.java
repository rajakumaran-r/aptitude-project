package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Service.RandomQuestionsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RandomQuestionsController {

    private final RandomQuestionsService service;

    public RandomQuestionsController(RandomQuestionsService service) {
        this.service = service;
    }

    // ✅ DEFAULT: get 1 random question
    @GetMapping("/random")
    public List<QuestionDTO> getOneRandom() {
        return service.getRandomQuestions(1);
    }

    // ✅ MOCK TEST: get N random questions
    @GetMapping("/random/{n}")
    public List<QuestionDTO> getRandom(@PathVariable int n) {
        return service.getRandomQuestions(n);
    }
}

