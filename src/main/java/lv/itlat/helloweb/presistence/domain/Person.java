package lv.itlat.helloweb.presistence.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

      @NotEmpty //Obligate to fill
    @Column(name = "FIRST_NAME")
    private String firstName;

        @NotEmpty
    @Column(name = "LAST_NAME")
    private String lastName;

        @NotEmpty
//    @Email
    @Column(name = "EMAIL")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}