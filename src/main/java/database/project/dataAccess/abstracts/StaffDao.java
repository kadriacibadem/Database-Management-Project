package database.project.dataAccess.abstracts;

import database.project.entites.concretes.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDao extends JpaRepository<Staff,Integer> {




}
