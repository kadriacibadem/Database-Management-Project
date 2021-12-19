package database.project.business.abstracts;
import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Disease;


public interface DiseaseService {
    Result add(Disease disease);
    Result delete(Disease disease);
}
