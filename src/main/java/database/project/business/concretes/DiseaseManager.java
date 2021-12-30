package database.project.business.concretes;

import database.project.business.abstracts.DiseaseService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.core.utilites.results.SuccessResult;
import database.project.dataAccess.abstracts.DiseaseDao;
import database.project.dataAccess.dtos.DiseaseWithStaffDto;
import database.project.entites.concretes.Disease;
import database.project.entites.concretes.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseManager implements DiseaseService {

    @Autowired
    public DiseaseManager(DiseaseDao diseaseDao){
        this.diseaseDao=diseaseDao;
    }

    private DiseaseDao diseaseDao;


    @Override
    public Result add(Disease disease) {
        this.diseaseDao.save(disease);
        return new SuccessResult("Hastalık eklendi veya güncellendi");
    }

    @Override
    public Result delete(Disease disease) {
        this.diseaseDao.delete(disease);
        return new SuccessResult("Hastalık silindi");
    }

    @Override
    public DataResult<List<Disease>> getAll() {
        return
                new SuccessDataResult<List<Disease>>(this.diseaseDao.findAll(),"Hastalıklar tablosu listelendi");
    }

    @Override
    public SuccessDataResult<List<Disease>> getMost3Disease() {
        return
                new SuccessDataResult<List<Disease>>(this.diseaseDao.getMost3Disease(), "Elemanlar arasında görülen en yaygın 3 hastalık ve hastalığa sahip elemanlar");
    }

    @Override
    public SuccessDataResult<List<Disease>> getMost3DiseaseOffCity(String city) {
        return
                new SuccessDataResult<List<Disease>>(this.diseaseDao.getMost3DiseaseOffCity(city),"Seçilen şehirde doğan elemanlar arasında en sık görülen 3 hastalık");
    }




}
