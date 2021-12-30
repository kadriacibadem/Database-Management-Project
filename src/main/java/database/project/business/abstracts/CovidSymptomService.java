package database.project.business.abstracts;

import database.project.core.utilites.results.DataResult;
import database.project.entites.concretes.CovidSymptom;

import java.util.List;

public interface CovidSymptomService {
    DataResult<List<CovidSymptom>> getMost3SymptomOffCovid();

    public DataResult<List<CovidSymptom>> getAll();


}
