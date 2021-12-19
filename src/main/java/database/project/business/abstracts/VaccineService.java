package database.project.business.abstracts;

import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Vaccine;

public interface VaccineService {

    Result add(Vaccine vaccine);
    Result delete(Vaccine vaccine);
}
