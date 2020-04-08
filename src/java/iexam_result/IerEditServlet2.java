package iexam_result;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/IerEditServlet2")  
public class IerEditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String oid=request.getParameter("ierid");  
        int ierid=Integer.parseInt(oid);  
        String ierindex_no=request.getParameter("ierindex_no");  
        String iergrade=request.getParameter("iergrade");  
        String iersubject=request.getParameter("iersubject");  
        String ierresult=request.getParameter("ierresult");  
          
        Ier ier=new Ier();  
        ier.setIerid(ierid);  
        ier.setIerindex_no(ierindex_no);  
        ier.setIergrade(iergrade);  
        ier.setIersubject(iersubject);  
        ier.setIerresult(ierresult);  
          
        int status=Ierdb.update(ier);  
        if(status>0){  
            response.sendRedirect("IerViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}