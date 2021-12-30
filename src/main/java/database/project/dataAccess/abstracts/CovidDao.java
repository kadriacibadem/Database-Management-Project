package database.project.dataAccess.abstracts;

import database.project.dataAccess.dtos.CovidWithStaffDto;
import database.project.entites.concretes.Covid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CovidDao extends JpaRepository<Covid,Integer> {


    @Query("select new database.project.dataAccess.dtos.CovidWithStaffDto" +
            "(s.id,c.covidId)"+
            "from Staff s inner join s.covid c where s.id = c.staffCovid.id and c.staffCovid.bloodGroup = :bloodGroup"
    )
    List<CovidWithStaffDto> getCovidWithBloodGroup(String bloodGroup);



}
