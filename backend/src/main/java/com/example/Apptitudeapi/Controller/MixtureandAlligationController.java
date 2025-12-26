package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Service.MixtureandAlligationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mixtureandalligation")
@CrossOrigin(origins = "*")
public class MixtureandAlligationController {

    private final MixtureandAlligationService service;

    public MixtureandAlligationController(MixtureandAlligationService service) {
        this.service = service;
    }

    // ✅ Fetch ALL mixture & alligation questions
    @GetMapping
    public List<QuestionDTO> getAll() {
        return service.getAllMixtureandAlligations();
    }

    // ✅ Fetch ONE random question
    @GetMapping("/random")
    public QuestionDTO getRandom() {
        return service.getRandomMixtureandAlligation();
    }

    // ✅ Fetch N random questions
    @GetMapping("/random/{count}")
    public List<QuestionDTO> getRandomCount(@PathVariable int count) {
        return service.getRandomMixtureandAlligations(count);
    }
}
