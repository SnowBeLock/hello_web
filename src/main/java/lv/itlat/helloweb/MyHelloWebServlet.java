package lv.itlat.helloweb;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myHelloWebServlet", urlPatterns = {"/myhello"},loadOnStartup = 1)
public class MyHelloWebServlet extends HttpServlet{
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>MY TRUE OWN SERVLET</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName=req.getParameter("firstName");
        String surname=req.getParameter("surname");
        PrintWriter printWriter= resp.getWriter();

        printWriter.println("<h1>Hello, my sweet "+firstName+" "+surname+". Glad to see you again!</h1> ");
        printWriter.close();
    }
}
