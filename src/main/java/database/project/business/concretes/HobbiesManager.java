package database.project.business.concretes;

import database.project.business.abstracts.HobbiesService;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessResult;
import database.project.dataAccess.abstracts.HobbiesDao;
import database.project.entites.concretes.Hobbies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HobbiesManager implements HobbiesService {

    @Autowired
    public HobbiesManager(HobbiesDao hobbiesDao){
        this.hobbiesDao=hobbiesDao;
    }

    private HobbiesDao hobbiesDao;

    @Override
    public Result add(Hobbies hobbies) {
        this.hobbiesDao.save(hobbies);
        return new SuccessResult("Hobi eklendi");
    }

    @Override
    public Result delete(Hobbies hobbies) {
        this.hobbiesDao.delete(hobbies);
        return new SuccessResult("Hobi silindi");
    }
}
