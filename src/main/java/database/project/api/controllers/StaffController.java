package database.project.api.controllers;


import database.project.business.abstracts.StaffService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.dataAccess.dtos.CovidWithStaffDto;
import database.project.dataAccess.dtos.StaffWithDiseaseCovidRecipeDto;
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



    @GetMapping("/lisans")
    public DataResult<List<CovidWithStaffDto>> getCovidWithStaffDetailsLisans(){
        return this.staffService.getCovidWithStaffDetailsLisans();

    }
    @GetMapping("/yukseklisans")
    public DataResult<List<CovidWithStaffDto>> getCovidWithStaffDetailsYuksekLisans(){
        return this.staffService.getCovidWithStaffDetailsYuksekLisans();

    }

    @GetMapping("/doktora")
    public DataResult<List<CovidWithStaffDto>> getCovidWithStaffDetailsDoktora(){
        return this.staffService.getCovidWithStaffDetailsDoktora();

    }


    @GetMapping("/soru8")
    public DataResult<List<Staff>> getMost3MedicineCovidStatus(){
        return this.staffService.getMost3MedicineCovidStatus();
    }

    @GetMapping("/soru9")
    public DataResult<List<StaffWithDiseaseCovidRecipeDto>> getStaffWithDiseaseCovidRecipeDetails(String medicine){
        return this.staffService.getStaffWithDiseaseCovidRecipeDetails(medicine);
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




}
