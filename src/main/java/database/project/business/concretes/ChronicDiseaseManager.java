package database.project.business.concretes;

import database.project.business.abstracts.ChronicDiseaseService;
import database.project.dataAccess.abstracts.ChronicDiseaseDao;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChronicDiseaseManager implements ChronicDiseaseService {
    @Autowired
    public ChronicDiseaseManager(ChronicDiseaseDao chronicDiseaseDao){
        this.chronicDiseaseDao = chronicDiseaseDao;

    }

    private ChronicDiseaseDao chronicDiseaseDao;


    @Override
    public Interval timeToTurnToCovidNegativeByChronicDisease(String chronicDisease) {
        return
                this.chronicDiseaseDao.timeToTurnToCovidNegativeByChronicDisease(chronicDisease);
    }
}
