package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Service.PermutationandCombinationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PermutationandCombinationController {

    private final PermutationandCombinationService service;

    public PermutationandCombinationController(
            PermutationandCombinationService service
    ) {
        this.service = service;
    }

    // ✅ ALL QUESTIONS
    @GetMapping("/permutationandcombination")
    public List<QuestionDTO> getAll() {
        return service.getAllPermutationandCombinations();
    }

    // ✅ RANDOM N QUESTIONS
    @GetMapping("/permutationandcombination/{number}")
    public List<QuestionDTO> getRandom(@PathVariable int number) {
        return service.getRandomPermutationandCombinations(number);
    }
}
