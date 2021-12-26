package database.project.dataAccess.abstracts;

import database.project.entites.concretes.Covid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CovidDao extends JpaRepository<Covid,Integer> {




}
