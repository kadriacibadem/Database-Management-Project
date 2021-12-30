package database.project.api.controllers;

import database.project.business.abstracts.VaccineService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getall")
    public DataResult<List<Vaccine>> getAll(){
        return this.vaccineService.getAll();

    }

    @GetMapping("/soru17")
    public DataResult<List<Float>> getBiontech(){
        return this.vaccineService.getBiontech();
    }

    @GetMapping("/soru17sinovac")
    public DataResult<List<Float>> getSinovac(){
        return this.vaccineService.getSinovac();
    }

}
