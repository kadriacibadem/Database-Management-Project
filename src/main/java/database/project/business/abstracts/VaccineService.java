package database.project.business.abstracts;

import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Vaccine;

import java.util.List;

public interface VaccineService {

    public DataResult<List<Vaccine>> getAll();
    Result add(Vaccine vaccine);
    Result delete(Vaccine vaccine);
}
