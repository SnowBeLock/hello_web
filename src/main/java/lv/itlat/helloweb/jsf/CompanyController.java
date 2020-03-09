package lv.itlat.helloweb.jsf;

import lv.itlat.helloweb.presistence.domain.Company;
import lv.itlat.helloweb.presistence.domain.Person;
import lv.itlat.helloweb.presistence.repository.CompanyRepository;
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
public class CompanyController {
    private static final Logger logger = Logger.getLogger(CompanyController.class);
    @Inject
    private CompanyRepository companyRepository;
    private Company company = new Company();
    private List<Company> companyList;
    @PostConstruct
    public void init() {
        companyList = companyRepository.getAll();
    }

    public void create() {
        companyRepository.create(company);
        companyList.add(0, company);
        company = new Company();
    }

    public void update() {
        companyRepository.update(companyList);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Update successful"));
    }

    public void delete(Company company) {
        companyRepository.delete(company);
        companyList.remove(company);
    }

    public List<Company> getPersonList() {
        return companyList;
    }

    public void setCompanyList(List<Company>  companyList) {
        this.companyList = companyList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

