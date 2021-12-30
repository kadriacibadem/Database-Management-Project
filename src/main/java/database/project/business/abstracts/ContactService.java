package database.project.business.abstracts;

import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.dataAccess.dtos.CovidWithStaffDto;
import database.project.entites.concretes.Contact;
import database.project.entites.concretes.Staff;

import java.util.List;


public interface ContactService {
    DataResult<List<Contact>> getAll();


    DataResult<List<Contact>> getMost3Contact();

}
