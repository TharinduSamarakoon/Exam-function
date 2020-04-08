package assignment;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ADeleteServlet")  
public class ADeleteServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String kid=request.getParameter("aid");  
        int aid=Integer.parseInt(kid);  
        Adb.delete(aid);  
        response.sendRedirect("AViewServlet");  
    }  
}