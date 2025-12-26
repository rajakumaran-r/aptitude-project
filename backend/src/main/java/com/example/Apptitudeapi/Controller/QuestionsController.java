package com.example.Apptitudeapi.Controller;

import com.example.Apptitudeapi.Service.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class QuestionsController {

    private final AgeService ageService;
    private final MixtureandAlligationService mixtureService;
    private final WorkAndTimeService workService;
    private final ProfitAndLossService profitService;
    private final SimpleInterestService simpleService;
    private final SpeedTimeDistanceService speedService;
    private final PipesandCisternService pipesService;
    private final PermutationandCombinationService permService;
    private final RandomQuestionsService randomService;

    public QuestionsController(
            AgeService ageService,
            MixtureandAlligationService mixtureService,
            WorkAndTimeService workService,
            ProfitAndLossService profitService,
            SimpleInterestService simpleService,
            SpeedTimeDistanceService speedService,
            PipesandCisternService pipesService,
            PermutationandCombinationService permService,
            RandomQuestionsService randomService
    ) {
        this.ageService = ageService;
        this.mixtureService = mixtureService;
        this.workService = workService;
        this.profitService = profitService;
        this.simpleService = simpleService;
        this.speedService = speedService;
        this.pipesService = pipesService;
        this.permService = permService;
        this.randomService = randomService;
    }

    @GetMapping("/questions")
    public List<?> getQuestionsByTopic(@RequestParam String topic) {

        switch (topic.toLowerCase()) {

            case "age":
                return ageService.getAllAges();

            case "mixtureandalligation":
                return mixtureService.getAllMixtureandAlligations();

            case "workandtime":
                return workService.getAllWorkAndTime();

            case "profitandloss":
                return profitService.getAllProfitAndLosses();

            case "simpleinterest":
                return simpleService.getAllSimpleInterests();


            case "speedtimedistance":
                return speedService.getAllSpeedTimeDistances();

            case "pipesandcistern":
                return pipesService.getAllPipesandCisterns();

            case "permutationandcombination":
                return permService.getAllPermutationandCombinations();


            case "random":
                return randomService.getRandomQuestions(20);

            default:
                return Collections.emptyList();
        }
    }
}
