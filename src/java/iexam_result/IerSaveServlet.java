package iexam_result;

import java.io.IOException;  


import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/IerSaveServlet")  
public class IerSaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String ierindex_no=request.getParameter("ierindex_no");  
        String iergrade=request.getParameter("iergrade");  
        String iersubject=request.getParameter("iersubject");  
        String ierresult=request.getParameter("ierresult");  
          
        Ier ier=new Ier();  
        ier.setIerindex_no(ierindex_no);  
        ier.setIergrade(iergrade);  
        ier.setIersubject(iersubject);  
        ier.setIerresult(ierresult);  
          
        int status=Ierdb.save(ier);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("mainUI.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}