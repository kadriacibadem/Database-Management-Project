package database.project.api.controllers;


import database.project.business.abstracts.StaffService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.dataAccess.dtos.CovidWithStaffDto;
import database.project.dataAccess.dtos.StaffWithDiseaseCovidRecipeDto;
import database.project.dataAccess.dtos.StaffWithDiseaseRecipeDto;
import database.project.dataAccess.dtos.StaffWithVaccineCovidDisease;
import database.project.entites.concretes.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    private StaffService staffService;

    @GetMapping("/getall")
    public DataResult<List<Staff>> getAll(){
        return this.staffService.getAll();

    }

    @PostMapping("/add")
    public Result add(@RequestBody Staff staff){
        return this.staffService.add(staff);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Staff staff){
        return this.staffService.delete(staff);
    }



    @GetMapping("/soru5")
    public DataResult<List<CovidWithStaffDto>> getCovidWithStaffEducationDetails(String education){
        return this.staffService.getCovidWithStaffEducationDetails(education);

    }



    @GetMapping("/soru8covidolanlar")
    public DataResult<List<Staff>> getMost3MedicineCovidStatus(){
        return this.staffService.getMost3MedicineCovidStatus();
    }

    @GetMapping("/soru8covidolmayanlar")
    public DataResult<List<Staff>> getMost3MedicineNoCovidStatus(){
        return this.staffService.getMost3MedicineNoCovidStatus();
    }





    @GetMapping("/soru9covidgeçirenler")
    public DataResult<List<StaffWithDiseaseCovidRecipeDto>> getStaffWithDiseaseCovidRecipeDetails(String medicine){
        return this.staffService.getStaffWithDiseaseCovidRecipeDetails(medicine);
    }

    @GetMapping("/soru9covidgeçirmeyenler")
    public DataResult<List<StaffWithDiseaseRecipeDto>> getStaffWithDiseaseNoCovidRecipeDetails(String medicine){
        return this.staffService.getStaffWithDiseaseNoCovidRecipeDetails(medicine);
    }





    @GetMapping("/soru10")
    public DataResult<List<StaffWithVaccineCovidDisease>> getStaffWithVaccineCovidDisease(String disease){
        return this.staffService.getStaffWithVaccineCovidDisease(disease);
    }





    @GetMapping("/soru11covidolanlar")
    public Float covidRateByVaccineStatus(){
        return this.staffService.covidRateByVaccineStatus();
    }

    @GetMapping("/soru11covidolmayanlar")
    public Float covidRateByNoVaccineStatus(){
        return this.staffService.covidRateByNoVaccineStatus();
    }






    @GetMapping("/soru19covidolan")
    public DataResult<List<Staff>> getMostDiseaseStaff(){
        return  this.staffService.getMostDiseaseStaff();
    }

    @GetMapping("/soru19covidolmayan")
    public DataResult<List<Staff>> getMostDiseaseStaffNoCovid(){
        return this.staffService.getMostDiseaseStaffNoCovid();
    }





}
