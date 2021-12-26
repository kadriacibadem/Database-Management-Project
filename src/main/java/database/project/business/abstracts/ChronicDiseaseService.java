package database.project.business.abstracts;

import org.joda.time.Interval;

import java.util.Date;

public interface ChronicDiseaseService {

    Interval timeToTurnToCovidNegativeByChronicDisease(String chronicDisease);

}
