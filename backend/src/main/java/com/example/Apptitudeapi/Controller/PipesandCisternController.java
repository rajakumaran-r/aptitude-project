package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.Service.PipesandCisternService;
import com.example.Apptitudeapi.model.PipesandCistern;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")   // ✅ VERY IMPORTANT
@CrossOrigin(origins = "*")
public class PipesandCisternController {

    private final PipesandCisternService service;

    public PipesandCisternController(PipesandCisternService service) {
        this.service = service;
    }

    @GetMapping("/pipesandcisterns")
    public List<PipesandCistern> getAll() {
        return service.getAllPipesandCisterns();
    }

    @GetMapping("/pipesandcistern")
    public PipesandCistern getRandom() {
        return service.getRandomPipesandCistern();
    }

    @GetMapping("/pipesandcisterns/{number}")
    public List<PipesandCistern> getRandom(@PathVariable int number) {
        return service.getRandomPipesandCisterns(number);
    }
}
