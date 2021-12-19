package database.project.api.controllers;

import database.project.business.abstracts.VaccineService;
import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vaccines")
public class VaccineController {


    @Autowired
    public VaccineController(VaccineService vaccineService){
        this.vaccineService = vaccineService;
    }

    private VaccineService vaccineService;


    @PostMapping("/add")
    public Result add(@RequestBody Vaccine vaccine){
        return this.vaccineService.add(vaccine);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Vaccine vaccine){
        return this.vaccineService.delete(vaccine);
    }

}
