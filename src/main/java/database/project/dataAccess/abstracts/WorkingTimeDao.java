package database.project.dataAccess.abstracts;

import database.project.entites.concretes.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTimeDao extends JpaRepository<WorkingTime,Integer> {

}
