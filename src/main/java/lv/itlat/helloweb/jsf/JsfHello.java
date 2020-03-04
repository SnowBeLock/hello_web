package lv.itlat.helloweb.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
@Named
@RequestScoped
public class JsfHello {
   private String message;
   private String result;
   private String secondMessage;

   public void getResultMessage(){
       result="Hello, "+message+secondMessage;
   }

    public String getSecondMessage() {
        return secondMessage;
    }

    public void setSecondMessage(String secondMessage) {
        this.secondMessage = secondMessage;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
