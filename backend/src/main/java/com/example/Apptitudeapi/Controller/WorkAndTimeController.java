package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Service.WorkAndTimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class WorkAndTimeController {

    private final WorkAndTimeService service;

    public WorkAndTimeController(WorkAndTimeService service) {
        this.service = service;
    }

    // ✅ ALL QUESTIONS
    @GetMapping("/workandtime")
    public List<QuestionDTO> getAll() {
        return service.getAllWorkAndTime();
    }

    // ✅ RANDOM N QUESTIONS
    @GetMapping("/workandtime/{n}")
    public List<QuestionDTO> getRandom(@PathVariable int n) {
        return service.getRandomWorkAndTime(n);
    }
}
