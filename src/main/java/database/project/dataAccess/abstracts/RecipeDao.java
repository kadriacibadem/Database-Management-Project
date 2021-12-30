package database.project.dataAccess.abstracts;

import database.project.entites.concretes.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeDao extends JpaRepository<Recipe,Integer> {

    @Query(nativeQuery = true,value = "Select r.* From  recipe r, Disease d  Where d.staffId IN (Select top 1 staffId From Covid Where StaffId NOt IN(Select staffId From Vaccine) Order By DATEDIFF (Day, covidPositiveDate, covidNegativeDate) desc) AND r.diseaseId = d.diseaseId AND (DATEDIFF(year, diseaseDate, getdate()) BETWEEN 0 AND 2)")
    List<Recipe> getRecipeWithDisease();

}
