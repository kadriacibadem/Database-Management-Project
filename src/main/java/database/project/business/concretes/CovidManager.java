package database.project.business.concretes;

import database.project.business.abstracts.CovidService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.core.utilites.results.SuccessResult;
import database.project.dataAccess.abstracts.CovidDao;
import database.project.dataAccess.dtos.CovidWithStaffDto;
import database.project.entites.concretes.Covid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CovidManager implements CovidService {

    @Autowired
    public CovidManager(CovidDao covidDao){
        this.covidDao = covidDao;

    }

    private final CovidDao covidDao;

    @Override
    public DataResult<List<Covid>> getAll() {
        return
                new SuccessDataResult<List<Covid>>(this.covidDao.findAll(),"Covid bilgileri listelendi");
    }

    @Override
    public Result add(Covid covid) {
        this.covidDao.save(covid);
        return new SuccessResult("Covid bilgisi eklendi veya güncellendi");
    }

    @Override
    public Result delete(Covid covid) {
        this.covidDao.delete(covid);
        return new SuccessResult("Covid bilgisi silindi");
    }

    @Override
    public DataResult<List<CovidWithStaffDto>> getCovidWithBloodGroup(String bloodGroup) {
        return
                new SuccessDataResult<List<CovidWithStaffDto>>(this.covidDao.getCovidWithBloodGroup(bloodGroup),"Kan grubuna göre covid olanlar");
    }


}
