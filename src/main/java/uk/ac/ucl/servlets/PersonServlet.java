package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// The servlet invoked to perform a search.
// The url http://localhost:8080/runsearch.html is mapped to calling doPost on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet(name="PersonServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Invoke the JSP page.
        System.out.println("Hello from the servlet!");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String age = request.getParameter("age");

        StringBuilder error = new StringBuilder();
        if (fname==null) {
            error.append("First name is required. ");
        }else if (lname==null) {
            error.append("Last name is required. ");
        }else if (age==null) {
            error.append("Age is required. ");
        }
        if (error.length()>0){
            request.setAttribute("error", error.toString());
            request.setAttribute("person", new Person());
        }
        else{
            request.setAttribute("person", new Person(fname, lname, Integer.parseInt(age)));
        }

        getServletContext().getRequestDispatcher("/name.jsp").forward(request, response);
    }
}
