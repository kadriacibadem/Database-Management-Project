package database.project.business.abstracts;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.entites.concretes.WorkingTime;

import java.util.List;

public interface WorkingTimeService {

    public DataResult<List<WorkingTime>> getAll();
    Result add(WorkingTime workingTime);
    Result delete(WorkingTime workingTime);

    int NumberOfPeopleWorkOnTheWeekendHaveCovid();

}
