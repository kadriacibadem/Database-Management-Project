package database.project.dataAccess.abstracts;

import database.project.entites.concretes.CovidSymptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CovidSymptomDao extends JpaRepository<CovidSymptom,Integer> {


    @Query(nativeQuery = true,value = "Select cs.* From CovidSymptom cs, Covid c where c.covidId = cs.covidId and cs.symptom IN (Select TOP 3 symptom From CovidSymptom GROUP by symptom order by Count(*) desc)")
    List<CovidSymptom> getMost3SymptomOffCovid();



}
