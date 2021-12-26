package database.project.api.controllers;

import database.project.business.abstracts.WorkingTimeService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.entites.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/working")
public class WorkingTimeController {

    @Autowired
    public WorkingTimeController(WorkingTimeService workingTimeService) {
        this.workingTimeService = workingTimeService;
    }

    private WorkingTimeService workingTimeService;


    @PostMapping("/add")
    public Result add(@RequestBody WorkingTime workingTime){
        return this.workingTimeService.add(workingTime);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody WorkingTime workingTime){
        return this.workingTimeService.delete(workingTime);
    }

    @GetMapping("/getall")
    public DataResult<List<WorkingTime>> getAll(){
        return this.workingTimeService.getAll();

    }

    @GetMapping("/soru18")
    public int NumberOfPeopleWorkOnTheWeekendHaveCovid(){
        return this.workingTimeService.NumberOfPeopleWorkOnTheWeekendHaveCovid();
    }

}
