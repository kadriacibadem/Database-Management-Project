package database.project.dataAccess.abstracts;

import database.project.entites.concretes.Covid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CovidDao extends JpaRepository<Covid,Integer> {
}
