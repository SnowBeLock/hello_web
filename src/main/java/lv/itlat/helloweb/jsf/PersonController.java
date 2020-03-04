package lv.itlat.helloweb.jsf;

import lv.itlat.helloweb.presistence.domain.Person;
import lv.itlat.helloweb.presistence.repository.PersonRepository;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PersonController {

    private static final Logger logger = Logger.getLogger(PersonController.class);

    @Inject
    private PersonRepository personRepository;

    private Person person = new Person();
    private List<Person> personList;

    @PostConstruct
    public void init() {
        personList = personRepository.getAll();
    }

    public void create() {
        personRepository.create(person);
        personList.add(0, person);
        person = new Person();
    }

    public void update() {
        personRepository.update(personList);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }

    public void delete(Person person) {
        personRepository.delete(person);
        personList.remove(person);
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
