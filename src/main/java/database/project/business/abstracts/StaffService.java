package database.project.business.abstracts;

import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.dataAccess.dtos.CovidWithStaffDto;
import database.project.dataAccess.dtos.StaffWithDiseaseCovidRecipeDto;
import database.project.dataAccess.dtos.StaffWithVaccineCovidDisease;
import database.project.entites.concretes.Staff;

import java.util.List;

public interface StaffService {
    public DataResult<List<Staff>> getAll();
    Result add(Staff staff);
    Result delete(Staff staff);


    DataResult<List<CovidWithStaffDto>> getCovidWithStaffDetailsLisans();
    DataResult<List<CovidWithStaffDto>> getCovidWithStaffDetailsYuksekLisans();
    DataResult<List<CovidWithStaffDto>> getCovidWithStaffDetailsDoktora();


    //DataResult<List<DiseaseWithStaffDto>> getDiseaseWithStaffDetails();



    DataResult<List<StaffWithDiseaseCovidRecipeDto>> getStaffWithDiseaseCovidRecipeDetails(String medicine);


    SuccessDataResult<List<StaffWithVaccineCovidDisease>> getStaffWithVaccineCovidDisease(String disease);


    SuccessDataResult<List<Staff>> getMost3MedicineCovidStatus();

    Float covidRateByVaccineStatus();

    Float covidRateByNoVaccineStatus();
}
