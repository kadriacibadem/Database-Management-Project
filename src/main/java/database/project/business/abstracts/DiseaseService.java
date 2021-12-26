package database.project.business.abstracts;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.dataAccess.dtos.DiseaseWithStaffDto;
import database.project.entites.concretes.Disease;

import java.util.List;


public interface DiseaseService {
    Result add(Disease disease);
    Result delete(Disease disease);
    public DataResult<List<Disease>> getAll();
    SuccessDataResult<List<Disease>> getMost3Disease();
    SuccessDataResult<List<Disease>> getMost3DiseaseOffCity(String city);
}
