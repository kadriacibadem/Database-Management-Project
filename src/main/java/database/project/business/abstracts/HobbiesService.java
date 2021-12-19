package database.project.business.abstracts;

import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Hobbies;

public interface HobbiesService {
    Result add(Hobbies hobbies);
    Result delete(Hobbies hobbies);
}
