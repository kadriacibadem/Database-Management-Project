package database.project.api.controllers;

import database.project.business.abstracts.CovidService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.dataAccess.dtos.CovidWithStaffDto;
import database.project.entites.concretes.Covid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getall")
    public DataResult<List<Covid>> getAll() {
        return this.covidService.getAll();
    }


    @GetMapping("/soru13")
    public DataResult<List<CovidWithStaffDto>> getCovidWithBloodGroup(String bloodGroup){
        return this.covidService.getCovidWithBloodGroup(bloodGroup);
    }


}
