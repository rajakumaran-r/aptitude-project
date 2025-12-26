package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.Service.AgeService;
import com.example.Apptitudeapi.model.Age;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")   // 🔥 THIS IS THE FIX
public class AgeController {

    private final AgeService ageService;

    @Autowired
    public AgeController(AgeService ageService) {
        this.ageService = ageService;
    }

    @GetMapping("/ages")
    public List<Age> getAllAges() {
        return ageService.getAllAges();
    }

    @GetMapping("/age")
    public Age getRandomAge() {
        return ageService.getRandomAge();
    }

    @GetMapping("/ages/{number}")
    public List<Age> getNumberOfAges(@PathVariable int number) {
        return ageService.getRandomNumbers(number);
    }
}
