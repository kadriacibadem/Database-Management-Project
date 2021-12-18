package database.project.dataAccess.abstracts;

import database.project.entites.concretes.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseDao extends JpaRepository<Disease,Integer> {

}
