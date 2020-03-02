package lv.itlat.helloweb.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "PERSON")

public class Person implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String surname;
    @Column(name = "EMAIL")
    private String email;

    public Integer getId(){return id;}
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
