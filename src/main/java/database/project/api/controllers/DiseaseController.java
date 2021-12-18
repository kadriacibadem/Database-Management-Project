package database.project.api.controllers;


import database.project.business.abstracts.DiseaseService;
import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
