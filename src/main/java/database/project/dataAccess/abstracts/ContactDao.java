package database.project.dataAccess.abstracts;

import database.project.entites.concretes.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactDao extends JpaRepository<Contact,Integer> {

    @Query(nativeQuery = true,value = "Select DISTINCT * From Contact c,Staff s where c.staffId = s.staffId and c.staffId IN (Select TOP 3 staffId From Contact GROUP by staffId order by Count(*) desc)")
    List<Contact> getMost3Contact();

}
