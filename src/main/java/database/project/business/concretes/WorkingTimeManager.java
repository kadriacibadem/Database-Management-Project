package database.project.business.concretes;

import database.project.business.abstracts.WorkingTimeService;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessResult;
import database.project.dataAccess.abstracts.WorkingTimeDao;
import database.project.entites.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkingTimeManager implements WorkingTimeService {

    @Autowired
    public WorkingTimeManager(WorkingTimeDao workingTimeDao){
        this.workingTimeDao = workingTimeDao;
    }

    private final WorkingTimeDao workingTimeDao;

    @Override
    public Result add(WorkingTime workingTime) {
        this.workingTimeDao.save(workingTime);
        return new SuccessResult("Çalışma saati eklendi");
    }

    @Override
    public Result delete(WorkingTime workingTime) {
        this.workingTimeDao.delete(workingTime);
        return new SuccessResult("Çalışma saati silindi");
    }
}
