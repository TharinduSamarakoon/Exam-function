package assignment;

import java.io.IOException;  


import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ASaveServlet")  
public class ASaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String atitle=request.getParameter("atitle");  
        String agrade=request.getParameter("agrade");  
        String afile=request.getParameter("afile");  
          
        A a=new A();  
        a.setAtitle(atitle);  
        a.setAgrade(agrade);  
        a.setAfile(afile);  

        int status=Adb.save(a);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("assignment.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}