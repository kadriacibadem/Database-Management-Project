package database.project.business.abstracts;

import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Recipe;

public interface RecipeService {
    Result add(Recipe recipe);
    Result delete(Recipe recipe);
}
