package lv.itlat.helloweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myHelloWebServlet", urlPatterns = {"/myhello"}, loadOnStartup = 1)
public class MyHelloWebServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>MY TRUE OWN SERVLET</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String comments = req.getParameter("comment");
        PrintWriter printWriter = resp.getWriter();

        printWriter.println("<h1>" + firstName + " " + surname + " logged in" + "</h1>");


        if (firstName == null ||  firstName.isEmpty()) {
            resp.sendError(resp.SC_BAD_REQUEST, "YOUR FIRS NAME IS EMPTY. WE NEEED TOUR NAME!!!");
        }
        printWriter.close();
    }
}
