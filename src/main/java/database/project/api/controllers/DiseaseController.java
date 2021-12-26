package database.project.api.controllers;


import database.project.business.abstracts.DiseaseService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.dataAccess.dtos.DiseaseWithStaffDto;
import database.project.entites.concretes.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disease")
public class DiseaseController {

    @Autowired
    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    private DiseaseService diseaseService;


    @PostMapping("/add")
    public Result add(@RequestBody Disease disease){
        return this.diseaseService.add(disease);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Disease disease){
        return this.diseaseService.delete(disease);
    }

    @GetMapping("/getall")
    public DataResult<List<Disease>> getAll(){
        return this.diseaseService.getAll();

    }
    @GetMapping("/soru6")
    public SuccessDataResult<List<Disease>> getMost3Disease(){
        return this.diseaseService.getMost3Disease();
    }
    @GetMapping("/soru7")
    public SuccessDataResult<List<Disease>> getMost3DiseaseOffCity(String city){
        return this.diseaseService.getMost3DiseaseOffCity(city);
    }

}
