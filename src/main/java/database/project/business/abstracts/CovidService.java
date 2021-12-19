package database.project.business.abstracts;

import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Covid;

public interface CovidService {

    Result add(Covid covid);
    Result delete(Covid covid);
}
