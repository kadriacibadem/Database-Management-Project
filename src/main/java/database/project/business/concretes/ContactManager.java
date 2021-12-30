
package database.project.business.concretes;

import database.project.business.abstracts.ContactService;
import database.project.core.utilites.results.DataResult;
import database.project.core.utilites.results.SuccessDataResult;
import database.project.dataAccess.abstracts.ContactDao;
import database.project.entites.concretes.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactManager implements ContactService {

    @Autowired
    public ContactManager (ContactDao contactDao){
        this.contactDao = contactDao;
    }

    private ContactDao contactDao;


    @Override
    public DataResult<List<Contact>> getAll() {
        return
                new SuccessDataResult<List<Contact>>(this.contactDao.findAll(),"Elemanların temaslıları listelendi");
    }


    @Override
    public DataResult<List<Contact>> getMost3Contact() {
            return
                    new SuccessDataResult<List<Contact>>(this.contactDao.getMost3Contact(),"En fazla temasta bulunmuş ilk 3 çalışan");
    }
}
