package database.project.dataAccess.abstracts;

import database.project.entites.concretes.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VaccineDao extends JpaRepository<Vaccine,Integer> {

    @Query(nativeQuery = true,value = "Select DATEDIFF (Day, covidPositiveDate, covidNegativeDate) From Covid c, Vaccine v Where v.staffId = c.staffId and vaccineName='Biontech'Order BY DATEDIFF (Day, covidPositiveDate, covidNegativeDate) DESC")
    List<Float> getBiontech();

    @Query(nativeQuery = true,value = "Select DATEDIFF (Day, covidPositiveDate, covidNegativeDate) From Covid c, Vaccine v Where v.staffId = c.staffId and vaccineName='Sinovac'Order BY DATEDIFF (Day, covidPositiveDate, covidNegativeDate) DESC")
    List<Float> getSinovac();

}
