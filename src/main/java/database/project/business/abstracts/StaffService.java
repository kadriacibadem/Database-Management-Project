package database.project.business.abstracts;

import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.Result;
import database.project.entites.concretes.Staff;

import java.util.List;

public interface StaffService {
    public DataResult<List<Staff>> getAll();
    Result add(Staff staff);
}
