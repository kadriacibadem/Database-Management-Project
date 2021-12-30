package database.project.business.abstracts;

import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.dataAccess.dtos.CovidWithStaffDto;
import database.project.entites.concretes.Covid;


import java.util.List;

public interface CovidService {
    public DataResult<List<Covid>> getAll();
    Result add(Covid covid);
    Result delete(Covid covid);


    DataResult<List<CovidWithStaffDto>> getCovidWithBloodGroup(String bloodGroup);

}
