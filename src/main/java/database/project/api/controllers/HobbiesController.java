package database.project.api.controllers;


import database.project.business.abstracts.HobbiesService;
import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Hobbies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hobbies")
public class HobbiesController {

    @Autowired
    public HobbiesController(HobbiesService hobbiesService){
        this.hobbiesService = hobbiesService;
    }
    private HobbiesService hobbiesService;


    @PostMapping("/add")
    public Result add(@RequestBody Hobbies hobbies){
       return this.hobbiesService.add(hobbies);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Hobbies hobbies){
        return this.hobbiesService.delete(hobbies);
    }


}
