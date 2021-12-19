package database.project.business.abstracts;
import database.project.core.utilites.results.Result;
import database.project.entites.concretes.WorkingTime;

public interface WorkingTimeService {

    Result add(WorkingTime workingTime);
    Result delete(WorkingTime workingTime);

}
