package database.project.dataAccess.abstracts;


import database.project.entites.concretes.Disease;
import database.project.entites.concretes.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiseaseDao extends JpaRepository<Disease,Integer> {


    @Query(nativeQuery = true,value = "Select d.* From Staff s , Disease d Where s.staffId = d.staffId and diseaseName IN(Select TOP 3 diseaseName From Disease group by diseaseName order by Count(*) desc)")
    List<Disease> getMost3Disease();


    @Query(nativeQuery = true,value = "Select d.* From Staff s,Disease d Where s.staffId = d.staffId and city=:city and diseasename IN (Select TOP 3 diseaseName From Disease GROUP by diseaseName order by Count(*) desc)")
    List<Disease> getMost3DiseaseOffCity(String city);





}
