package database.project.business.concretes;

import database.project.business.abstracts.StaffService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.core.utilites.results.SuccessResult;
import database.project.dataAccess.abstracts.StaffDao;
import database.project.entites.concretes.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffManager implements StaffService {


    @Autowired
    public StaffManager(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    private StaffDao staffDao;


    @Override
    public DataResult<List<Staff>> getAll() {
        return
              new SuccessDataResult<List<Staff>>(this.staffDao.findAll(),"Elemanlar listelendi");

    }

    @Override
    public Result add(Staff staff) {
        this.staffDao.save(staff);
        return new SuccessResult("Eleman eklendi");
    }

    @Override
    public Result delete(Staff staff) {
        this.staffDao.delete(staff);
        return new SuccessResult("Eleman silindi");
    }


}
