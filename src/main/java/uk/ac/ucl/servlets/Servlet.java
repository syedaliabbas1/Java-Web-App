package uk.ac.ucl.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String copyRightYear=getServletConfig().getInitParameter("copyRightYear");
        if(copyRightYear!=null){
            System.out.println("Copy right year: "+copyRightYear);
            response.getWriter().write(copyRightYear);
        }else{
            System.out.println("No copy right year found");
            response.getWriter().write("No copy right year found");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
