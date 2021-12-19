package database.project.business.concretes;

import database.project.business.abstracts.VaccineService;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessResult;
import database.project.dataAccess.abstracts.VaccineDao;
import database.project.entites.concretes.Staff;
import database.project.entites.concretes.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineManager implements VaccineService {

    @Autowired
    public VaccineManager(VaccineDao vaccineDao){
        this.vaccineDao = vaccineDao;
    }

    private VaccineDao vaccineDao;
    private Staff staff;


    @Override
    public Result add(Vaccine vaccine) {
        this.vaccineDao.save(vaccine);
        return new SuccessResult("Aşı bilgisi eklendi");
    }

    @Override
    public Result delete(Vaccine vaccine) {
        this.vaccineDao.delete(vaccine);
        return new SuccessResult("Aşı bilgisi silindi");
    }
}
