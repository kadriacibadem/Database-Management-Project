package database.project.business.concretes;

import database.project.business.abstracts.WorkingTimeService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.core.utilites.results.SuccessResult;
import database.project.dataAccess.abstracts.WorkingTimeDao;
import database.project.entites.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTimeManager implements WorkingTimeService {

    @Autowired
    public WorkingTimeManager(WorkingTimeDao workingTimeDao){
        this.workingTimeDao = workingTimeDao;
    }

    private final WorkingTimeDao workingTimeDao;

    @Override
    public DataResult<List<WorkingTime>> getAll() {
        return
                new SuccessDataResult<List<WorkingTime>>(this.workingTimeDao.findAll(),"Elemanlar'ın çalışma saatleri listelendi");
    }

    @Override
    public Result add(WorkingTime workingTime) {
        this.workingTimeDao.save(workingTime);
        return new SuccessResult("Çalışma saati eklendi veya güncellendi");
    }

    @Override
    public Result delete(WorkingTime workingTime) {
        this.workingTimeDao.delete(workingTime);
        return new SuccessResult("Çalışma saati silindi");
    }

    @Override
    public int NumberOfPeopleWorkOnTheWeekendHaveCovid() {
        return this.workingTimeDao.NumberOfPeopleWorkOnTheWeekendHaveCovid();
    }
}
