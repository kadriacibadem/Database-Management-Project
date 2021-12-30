package database.project.business.concretes;

import database.project.business.abstracts.CovidSymptomService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.dataAccess.abstracts.CovidSymptomDao;
import database.project.entites.concretes.CovidSymptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CovidSymptomManager implements CovidSymptomService {


    @Autowired
    public CovidSymptomManager(CovidSymptomDao covidSymptomDao){
        this.covidSymptomDao = covidSymptomDao;

    }

    private final CovidSymptomDao covidSymptomDao;


    @Override
    public DataResult<List<CovidSymptom>> getMost3SymptomOffCovid() {
        return
                new SuccessDataResult<List<CovidSymptom>>(this.covidSymptomDao.getMost3SymptomOffCovid(), "test");
    }

    @Override
    public DataResult<List<CovidSymptom>> getAll() {
        return
                new SuccessDataResult<List<CovidSymptom>>(this.covidSymptomDao.findAll(),"Covid semptomları");
    }
}
