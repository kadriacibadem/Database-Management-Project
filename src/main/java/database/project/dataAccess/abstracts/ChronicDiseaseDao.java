package database.project.dataAccess.abstracts;

import database.project.entites.concretes.ChronicDisease;
import org.joda.time.Interval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface ChronicDiseaseDao extends JpaRepository<ChronicDisease,Integer> {


    @Query(nativeQuery = true,value = "Select * DATEDIFF (Day, covidPositiveDate, covidNegativeDate) From Covid c1 Where EXISTS(Select * From ChronicDisease c2 Where c1.covidId = c2.covidId And chronicDisease =:chronicDisease")
    Interval timeToTurnToCovidNegativeByChronicDisease(String chronicDisease);


}
