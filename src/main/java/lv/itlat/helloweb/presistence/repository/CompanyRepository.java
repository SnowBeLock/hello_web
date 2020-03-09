package lv.itlat.helloweb.presistence.repository;

import lv.itlat.helloweb.presistence.domain.Company;
import lv.itlat.helloweb.presistence.domain.Person;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class CompanyRepository {
    @PersistenceContext(unitName = "companyPU") //What is PU?
    private EntityManager em;
    public EntityManager getEntityManager() {
        return em;
    }
    @Transactional
    public Company create(Company company){
        getEntityManager().persist(company);
        return company;
    }

    public void update(List<Company> companies) {
        for (Company company : companies) {
            getEntityManager().merge(company);
        }
    }

    public void delete(Company company) {
        if (getEntityManager().contains(company)) {
            getEntityManager().remove(company);
        } else {
            Person managedPerson = getEntityManager().find(Person.class, company.getId());
            if (managedPerson != null) {
                getEntityManager().remove(managedPerson);
            }
        }
    }
    public List<Company> getAll() {
        return getEntityManager().createQuery("SELECT p FROM Person p", Company.class).getResultList();
    }

}
