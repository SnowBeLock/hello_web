package lv.itlat.helloweb.presistence.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class Company implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name="TITLE")
    private String title;

    @NotEmpty
    @Column(name="FYEAR")
    private String foundationYear;

    @NotEmpty
    @Column(name="FOUNDER")
    private String founder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationDay(String foundationDay) {
        this.foundationYear = foundationDay;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }
}
