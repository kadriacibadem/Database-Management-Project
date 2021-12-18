package database.project.dataAccess.abstracts;

import database.project.entites.concretes.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeDao extends JpaRepository<Recipe,Integer> {
}
