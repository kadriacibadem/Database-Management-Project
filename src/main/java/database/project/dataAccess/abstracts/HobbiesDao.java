package database.project.dataAccess.abstracts;

import database.project.entites.concretes.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbiesDao extends JpaRepository<Hobbies,Integer> {
}
