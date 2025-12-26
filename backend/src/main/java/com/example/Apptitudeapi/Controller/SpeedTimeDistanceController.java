package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Service.SpeedTimeDistanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SpeedTimeDistanceController {

    private final SpeedTimeDistanceService service;

    public SpeedTimeDistanceController(SpeedTimeDistanceService service) {
        this.service = service;
    }

    // ✅ ALL QUESTIONS
    @GetMapping("/speedtimedistance")
    public List<QuestionDTO> getAll() {
        return service.getAllSpeedTimeDistances();
    }

    // ✅ RANDOM N QUESTIONS
    @GetMapping("/speedtimedistance/{n}")
    public List<QuestionDTO> getRandom(@PathVariable int n) {
        return service.getRandomSpeedTimeDistances(n);
    }
}
