package database.project.business.concretes;

import database.project.business.abstracts.StaffService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.core.utilites.results.SuccessResult;
import database.project.dataAccess.abstracts.StaffDao;
import database.project.dataAccess.dtos.CovidWithStaffDto;
import database.project.dataAccess.dtos.StaffWithDiseaseCovidRecipeDto;
import database.project.dataAccess.dtos.StaffWithVaccineCovidDisease;
import database.project.entites.concretes.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffManager implements StaffService {


    @Autowired
    public StaffManager(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    private StaffDao staffDao;


    @Override
    public DataResult<List<Staff>> getAll() {
        return
                new SuccessDataResult<List<Staff>>(this.staffDao.findAll(), "Elemanlar listelendi");

    }

    @Override
    public Result add(Staff staff) {
        this.staffDao.save(staff);
        return new SuccessResult("Eleman eklendi veya güncellendi");
    }

    @Override
    public Result delete(Staff staff) {
        this.staffDao.delete(staff);
        return new SuccessResult("Eleman silindi");
    }

    // Soru 1 {
    @Override
    public DataResult<List<CovidWithStaffDto>> getCovidWithStaffDetailsLisans() {
        return
                new SuccessDataResult<List<CovidWithStaffDto>>(this.staffDao.getCovidWithStaffDetailsLisans(), "Eğitim durumu lisans olup covid olanlar;");
    }

    @Override
    public DataResult<List<CovidWithStaffDto>> getCovidWithStaffDetailsYuksekLisans() {
        return
                new SuccessDataResult<List<CovidWithStaffDto>>(this.staffDao.getCovidWithStaffDetailsYuksekLisans(), "Eğitim durumu yüksek lisans olup covid olanlar;");
    }

    @Override
    public DataResult<List<CovidWithStaffDto>> getCovidWithStaffDetailsDoktora() {
        return
                new SuccessDataResult<List<CovidWithStaffDto>>(this.staffDao.getCovidWithStaffDetailsDoktora(), "Eğitim durumu doktora olup covid olanlar");
    }

    @Override
    public DataResult<List<StaffWithDiseaseCovidRecipeDto>> getStaffWithDiseaseCovidRecipeDetails(String medicine) {
        return
                new SuccessDataResult<List<StaffWithDiseaseCovidRecipeDto>>(this.staffDao.getStaffWithDiseaseCovidRecipeDetails(medicine),"Belirli bir ilacı kullanıp covid geçirenler");
    }

    @Override
    public SuccessDataResult<List<StaffWithVaccineCovidDisease>> getStaffWithVaccineCovidDisease(String disease) {
        return
                new SuccessDataResult<List<StaffWithVaccineCovidDisease>>(this.staffDao.getStaffWithVaccineCovidDisease(disease),"Biontech aşısı olup belirli bir hastalığı önceden geçirip covid olanlar" );
    }

    @Override
    public SuccessDataResult<List<Staff>> getMost3MedicineCovidStatus() {
        return
                new SuccessDataResult<List<Staff>>(this.staffDao.getMost3MedicineCovidStatus(),"En yaygın kullanılan ilk 3 ilacı kullanıp covid olan elemanlar");
    }

    @Override
    public Float covidRateByVaccineStatus() {
        return
                this.staffDao.covidRateByVaccineStatus();
    }

    @Override
    public Float covidRateByNoVaccineStatus() {
        return
                this.staffDao.covidRateByNoVaccineStatus();
    }


}
