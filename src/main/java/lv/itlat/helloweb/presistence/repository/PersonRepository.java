package lv.itlat.helloweb.presistence.repository;


import lv.itlat.helloweb.model.Person;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
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

    public List<Person> getAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().
                createQuery();
        cq.select(cq.from(Person.class));
        return getEntityManager().createQuery(cq).getResultList();

    }
}
