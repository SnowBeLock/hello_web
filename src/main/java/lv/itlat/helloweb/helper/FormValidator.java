package lv.itlat.helloweb.helper;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class FormValidator {

    Map<String, String> errors = new HashMap<>();

    public void validateRegistration(String firstName,String surname, String email){
        errors.clear();
        if(firstName==null||firstName.isEmpty()){
            errors.put("firstName","First Name can not be empty");
        }
        if(surname==null||surname.isEmpty()){

            errors.put("surname","TAKS GDE FAMILIJA?");
        }
        if(email.isEmpty()||email==null){

            errors.put("email","Emailis ir tukšs");
        }
    }
    public Map<String,String> getErrors(){
        return errors;
    }

}
