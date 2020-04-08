package exam_result;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ErEditServlet2")  
public class ErEditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String kid=request.getParameter("erid");  
        int erid=Integer.parseInt(kid);  
        String ertitle=request.getParameter("ertitle");  
        String ergrade=request.getParameter("ergrade");  
        String erfile=request.getParameter("erfile");   
          
        Er er=new Er();  
        er.setErid(erid);  
        er.setErtitle(ertitle);  
        er.setErgrade(ergrade);  
        er.setErfile(erfile);  
          
        int status=Erdb.update(er);  
        if(status>0){  
            response.sendRedirect("ErViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}