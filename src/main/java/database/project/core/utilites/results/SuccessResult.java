package database.project.core.utilites.results;

import java.util.List;

public class SuccessResult extends Result{


    public SuccessResult(){
        super(true);
    }

    public SuccessResult(String message){
        super(true,message);
    }




}
