package database.project.api.controllers;

import database.project.business.abstracts.ContactService;
import database.project.core.utilites.results.DataResult;
import database.project.entites.concretes.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }
    private ContactService contactService;



    @GetMapping("/soru16")
    public DataResult<List<Contact>> getMost3Contact(){
        return this.contactService.getMost3Contact();
    }

    @GetMapping("/contacts")
    public DataResult<List<Contact>> getContacts(){
        return this.contactService.getAll();
    }



}
