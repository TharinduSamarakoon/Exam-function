package exam_result;

import java.io.IOException;  


import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ErSaveServlet")  
public class ErSaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String ertitle=request.getParameter("ertitle");  
        String ergrade=request.getParameter("ergrade");  
        String erfile=request.getParameter("erfile");  
          
        Er er=new Er();  
        er.setErtitle(ertitle);  
        er.setErgrade(ergrade);  
        er.setErfile(erfile);  
          
        int status=Erdb.save(er);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("mainUI.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}