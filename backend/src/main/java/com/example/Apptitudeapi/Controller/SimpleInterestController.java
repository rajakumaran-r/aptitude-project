package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Service.SimpleInterestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SimpleInterestController {

    private final SimpleInterestService service;

    public SimpleInterestController(SimpleInterestService service) {
        this.service = service;
    }

    // ✅ ALL QUESTIONS
    @GetMapping("/simpleinterest")
    public List<QuestionDTO> getAll() {
        return service.getAllSimpleInterests();
    }

    // ✅ RANDOM N QUESTIONS
    @GetMapping("/simpleinterest/{n}")
    public List<QuestionDTO> getRandom(@PathVariable int n) {
        return service.getRandomSimpleInterests(n);
    }
}
