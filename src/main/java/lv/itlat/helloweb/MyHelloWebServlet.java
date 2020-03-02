package lv.itlat.helloweb;

import lv.itlat.helloweb.helper.FormValidator;
import lv.itlat.helloweb.model.Person;
import lv.itlat.helloweb.presistence.repository.PersonRepository;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@WebServlet(name = "myHelloWebServlet", urlPatterns = {"/myhello"}, loadOnStartup = 1)
public class MyHelloWebServlet extends HttpServlet {
@Inject
PersonRepository personRepository;

    private Logger logger= Logger.getLogger(MyHelloWebServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       req.getRequestDispatcher("Index.jsp").include(req,resp);
    }
    @Inject
 private FormValidator formValidator;

    @Override
    public void init() throws ServletException {
        logger.info("Servlet initialized");
        logger.info("FV: " + formValidator);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        formValidator.validateRegistration(firstName,surname,email);
        final Map<String ,String >errors=formValidator.getErrors();

        if(!errors.isEmpty()){
            req.setAttribute("errors",errors);
            doGet(req,resp);
            return;
        }

        String gender = req.getParameter("gender");
        String comments = req.getParameter("comment");

        final Person person=new Person();
        person.setEmail(email);
        person.setFirstName(firstName);
        person.setSurname(surname);

        personRepository.create(person);

        req.setAttribute("person",person);

        getServletContext().getRequestDispatcher("/result.jsp").forward(req,resp);
//
//        logger.info("Mandatory fields: "+firstName+" "+surname+" "+email+" "+gender+" "+comments);
//
//        PrintWriter printWriter = resp.getWriter();
//
//        printWriter.println("<h1>" + firstName + " " + surname + " logged in" + "</h1>");
//
//
//        if (firstName == null ||  firstName.isEmpty()) {
//            resp.sendError(resp.SC_BAD_REQUEST, "YOUR FIRS NAME IS EMPTY. WE NEEED TOUR NAME!!!");
//        }
//
//        if (!email.contains("@")||!email.contains(".")||email.equals("")) {
//            resp.sendError(resp.SC_BAD_REQUEST, "DO NOT LIE TO ME");
//        }
//
//        printWriter.close();
//        logger.info("Servlet finished");
    }
}
