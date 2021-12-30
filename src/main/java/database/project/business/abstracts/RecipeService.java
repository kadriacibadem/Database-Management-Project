package database.project.business.abstracts;

import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.entites.concretes.Recipe;


import java.util.List;

public interface RecipeService {
    public DataResult<List<Recipe>> getAll();
    Result add(Recipe recipe);
    Result delete(Recipe recipe);

    SuccessDataResult<List<Recipe>> getDiseaseWithRecipe();
}
