package database.project.business.concretes;

import database.project.business.abstracts.DiseaseService;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessResult;
import database.project.dataAccess.abstracts.DiseaseDao;
import database.project.entites.concretes.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return new SuccessResult("Hastalık eklendi");
    }

    @Override
    public Result delete(Disease disease) {
        this.diseaseDao.delete(disease);
        return new SuccessResult("Hastalık silindi");
    }
}
