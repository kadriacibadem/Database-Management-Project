package database.project.business.abstracts;

import org.joda.time.Days;
import org.joda.time.Interval;
import org.springframework.stereotype.Service;

import java.util.Date;


public interface ChronicDiseaseService {

    Integer timeToTurnToCovidNegativeByChronicDisease(String chronicDisease);

}
