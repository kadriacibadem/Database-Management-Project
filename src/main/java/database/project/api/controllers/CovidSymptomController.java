package database.project.api.controllers;


import database.project.business.abstracts.CovidSymptomService;
import database.project.core.utilites.results.DataResult;
import database.project.entites.concretes.CovidSymptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/covidsymptom")
public class CovidSymptomController {

    @Autowired
    public CovidSymptomController(CovidSymptomService covidSymptomService){
        this.covidSymptomService = covidSymptomService;
    }

    private final CovidSymptomService covidSymptomService;


    @GetMapping("/soru15")
    public DataResult<List<CovidSymptom>> getMost3SymptomOffCovid(){
        return this.covidSymptomService.getMost3SymptomOffCovid();
    }

    @GetMapping("/getAll")
    public DataResult<List<CovidSymptom>> getAll(){
        return this.covidSymptomService.getAll();
    }

}
