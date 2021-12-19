package database.project.dataAccess.abstracts;

import database.project.entites.concretes.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineDao extends JpaRepository<Vaccine,Integer> {

}
