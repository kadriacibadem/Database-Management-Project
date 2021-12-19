package database.project.api.controllers;

import database.project.business.abstracts.CovidService;
import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Covid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/covid")
public class CovidController {
    @Autowired
    public CovidController(CovidService covidService){
        this.covidService = covidService;
    }

    private final CovidService covidService;

    @PostMapping("/add")
    public Result add(@RequestBody Covid covid){
        return this.covidService.add(covid);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Covid covid){
        return this.covidService.delete(covid);
    }


}
