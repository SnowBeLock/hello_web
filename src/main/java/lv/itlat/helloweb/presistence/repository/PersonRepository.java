package lv.itlat.helloweb.presistence.repository;
import lv.itlat.helloweb.presistence.domain.Person;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class PersonRepository {

    @PersistenceContext(unitName = "personsPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    public Person create(Person person) {
        getEntityManager().persist(person);
        return person;
    }

    public void update(List<Person> persons) {
        for (Person person : persons) {
            getEntityManager().merge(person);
        }
    }

    public void delete(Person person) {
        if (getEntityManager().contains(person)) {
            getEntityManager().remove(person);
        } else {
            Person managedPerson = getEntityManager().find(Person.class, person.getId());
            if (managedPerson != null) {
                getEntityManager().remove(managedPerson);
            }
        }
    }

    public List<Person> getAll() {
        return getEntityManager().createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }
}