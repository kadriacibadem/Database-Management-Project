package database.project.business.concretes;

import database.project.business.abstracts.CovidService;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessResult;
import database.project.dataAccess.abstracts.CovidDao;
import database.project.entites.concretes.Covid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidManager implements CovidService {

    @Autowired
    public CovidManager(CovidDao covidDao){
        this.covidDao = covidDao;

    }

    private final CovidDao covidDao;

    @Override
    public Result add(Covid covid) {
        this.covidDao.save(covid);
        return new SuccessResult("Covid bilgisi eklendi");
    }

    @Override
    public Result delete(Covid covid) {
        this.covidDao.delete(covid);
        return new SuccessResult("Covid bilgisi silindi");
    }
}
