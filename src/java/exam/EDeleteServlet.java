package exam;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EDeleteServlet")  
public class EDeleteServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String pid=request.getParameter("eid");  
        int eid=Integer.parseInt(pid);  
        Edb.delete(eid);  
        response.sendRedirect("EViewServlet");  
    }  
}
