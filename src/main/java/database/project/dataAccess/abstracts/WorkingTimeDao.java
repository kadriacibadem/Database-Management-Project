package database.project.dataAccess.abstracts;

import database.project.entites.concretes.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkingTimeDao extends JpaRepository<WorkingTime,Integer> {


    @Query(nativeQuery = true,value = "Select Count(*)  From Covid c Where EXISTS(Select * From WorkingTime w Where c.staffId = w.staffId AND Day IN('Cumartesi','Pazar'))")
    int NumberOfPeopleWorkOnTheWeekendHaveCovid();
}
