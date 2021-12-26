package database.project.business.concretes;

import database.project.business.abstracts.RecipeService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.core.utilites.results.SuccessResult;
import database.project.dataAccess.abstracts.RecipeDao;
import database.project.entites.concretes.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeManager implements RecipeService {


    @Autowired
    public RecipeManager(RecipeDao recipeDao){
        this.recipeDao=recipeDao;
    }

    private RecipeDao recipeDao;


    @Override
    public DataResult<List<Recipe>> getAll() {
        return
                new SuccessDataResult<List<Recipe>>(this.recipeDao.findAll(),"Elemanların reçeteleri listelendi");
    }

    @Override
    public Result add(Recipe recipe) {
        this.recipeDao.save(recipe);
        return new SuccessResult("Reçete eklendi veya güncellendi");
    }

    @Override
    public Result delete(Recipe recipe) {
        this.recipeDao.delete(recipe);
        return new SuccessResult("Hastalık silindi");
    }
}
