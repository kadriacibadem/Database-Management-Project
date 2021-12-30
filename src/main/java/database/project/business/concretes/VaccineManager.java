package database.project.business.concretes;

import database.project.business.abstracts.VaccineService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.core.utilites.results.SuccessResult;
import database.project.dataAccess.abstracts.VaccineDao;
import database.project.entites.concretes.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineManager implements VaccineService {

    @Autowired
    public VaccineManager(VaccineDao vaccineDao){
        this.vaccineDao = vaccineDao;
    }

    private VaccineDao vaccineDao;



    @Override
    public DataResult<List<Vaccine>> getAll() {
        return
                new SuccessDataResult<List<Vaccine>>(this.vaccineDao.findAll(),"Elemanlar'ın aşıları listelendi");
    }

    @Override
    public Result add(Vaccine vaccine) {
        this.vaccineDao.save(vaccine);
        return new SuccessResult("Aşı bilgisi eklendi veya güncellendi");
    }

    @Override
    public Result delete(Vaccine vaccine) {
        this.vaccineDao.delete(vaccine);
        return new SuccessResult("Aşı bilgisi silindi");
    }

    @Override
    public DataResult<List<Float>> getBiontech() {
        return
                new SuccessDataResult<List<Float>>(this.vaccineDao.getBiontech(),"Biontech aşısının etkinliği");
    }

    @Override
    public DataResult<List<Float>> getSinovac() {
        return
                new SuccessDataResult<List<Float>>(this.vaccineDao.getSinovac(),"Sinovac aşısının etkinliği");
    }
}
