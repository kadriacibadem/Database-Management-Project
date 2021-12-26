package database.project.dataAccess.abstracts;

import database.project.entites.concretes.CovidSymptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CovidSymptomDao extends JpaRepository<CovidSymptom,Integer> {


    @Query(nativeQuery = true,value = "Select Top 3 symptom, Count(CovidId) From CovidSymptom Group BY symptom Order BY Count(covidId)DESC"
            )
    List<CovidSymptom> getMost3SymptomOffCovid();

}
