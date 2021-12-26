package database.project.api.controllers;

import database.project.business.abstracts.RecipeService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    private RecipeService recipeService;


    @PostMapping("/add")
    public Result add(@RequestBody Recipe recipe){
        return this.recipeService.add(recipe);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Recipe recipe){
        return this.recipeService.delete(recipe);
    }

    @GetMapping("/getall")
    public DataResult<List<Recipe>> getAll(){
        return this.recipeService.getAll();

    }

}
