package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.DTO.QuestionDTO;
import com.example.Apptitudeapi.Service.ProfitAndLossService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProfitAndLossController {

    private final ProfitAndLossService service;

    public ProfitAndLossController(ProfitAndLossService service) {
        this.service = service;
    }

    // ✅ ALL QUESTIONS
    @GetMapping("/profitandloss")
    public List<QuestionDTO> getAll() {
        return service.getAllProfitAndLosses();
    }

    // ✅ RANDOM N QUESTIONS
    @GetMapping("/profitandloss/{number}")
    public List<QuestionDTO> getRandom(@PathVariable int number) {
        return service.getRandomProfitAndLosses(number);
    }
}
