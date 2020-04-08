package assignment_result;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ArDeleteServlet")  
public class ArDeleteServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String lid=request.getParameter("arid");  
        int arid=Integer.parseInt(lid);  
        Ardb.delete(arid);  
        response.sendRedirect("ViewServlet");  
    }  
}