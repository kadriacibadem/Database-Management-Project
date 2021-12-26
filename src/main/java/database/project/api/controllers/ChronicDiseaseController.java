package database.project.api.controllers;

import database.project.business.abstracts.ChronicDiseaseService;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/chronicdisease")
public class ChronicDiseaseController {

    @Autowired
    public ChronicDiseaseController(ChronicDiseaseService chronicDiseaseService){
        this.chronicDiseaseService = chronicDiseaseService;
    }

    private final ChronicDiseaseService chronicDiseaseService;


    @GetMapping("/soru12")
    public Interval timeToTurnToCovidNegativeByChronicDisease(String chronicDisease){
        return this.chronicDiseaseService.timeToTurnToCovidNegativeByChronicDisease(chronicDisease);
    }


}
