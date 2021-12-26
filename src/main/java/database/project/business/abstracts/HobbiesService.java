package database.project.business.abstracts;

import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Hobbies;


import java.util.List;

public interface HobbiesService {
    public DataResult<List<Hobbies>> getAll();
    Result add(Hobbies hobbies);
    Result delete(Hobbies hobbies);
}
