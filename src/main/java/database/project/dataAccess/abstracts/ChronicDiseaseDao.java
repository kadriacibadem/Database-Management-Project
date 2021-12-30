package database.project.dataAccess.abstracts;

import database.project.entites.concretes.ChronicDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ChronicDiseaseDao extends JpaRepository<ChronicDisease,Integer> {


    @Query(nativeQuery = true,value = "select DATEDIFF (DAY, c1.covidPositiveDate, c1.covidNegativeDate) From Covid c1 Where EXISTS (Select * From ChronicDisease c2 Where chronicDisease=:chronicDisease and c2.covidId = c1.covidId) ")
    Integer timeToTurnToCovidNegativeByChronicDisease(String chronicDisease);


}
