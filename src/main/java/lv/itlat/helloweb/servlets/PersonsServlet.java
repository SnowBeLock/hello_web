package lv.itlat.helloweb.servlets;

import lv.itlat.helloweb.model.Person;
import lv.itlat.helloweb.presistence.repository.PersonRepository;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "personsServlet", urlPatterns = "/persons", loadOnStartup = 1)
public class PersonsServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(PersonsServlet.class);

    @Inject
    private PersonRepository personRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Person> persons = personRepository.getAll();
        req.setAttribute("persons", persons);
        getServletContext().getRequestDispatcher("/persons.jsp").forward(req, resp);

    }
}