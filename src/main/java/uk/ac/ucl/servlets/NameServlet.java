package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

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
@WebServlet(name="NameServlet", urlPatterns = "/name")
public class NameServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Hello from the servlet!");
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
        }
        else{
            request.setAttribute("fname", fname);
            request.setAttribute("lname", lname);
            request.setAttribute("age", age);
        }

        getServletContext().getRequestDispatcher("/secondary").forward(request, response);
    }
}
