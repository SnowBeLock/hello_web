package lv.itlat.helloweb.model;

public class Person {
    private String firstName;
    private String surname;
    private String email;
    //GETTERS OF NAME; SURNAME; EMAIL.
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
