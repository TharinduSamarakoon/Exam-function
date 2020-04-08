package assignment;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/AEditServlet2")  
public class AEditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String kid=request.getParameter("aid");  
        int aid=Integer.parseInt(kid);  
        String atitle=request.getParameter("atitle");  
        String agrade=request.getParameter("agrade");  
        String afile=request.getParameter("afile");    
          
        A a=new A();  
        a.setAid(aid);  
        a.setAtitle(atitle);  
        a.setAgrade(agrade);  
        a.setAfile(afile);    
          
        int status=Adb.update(a);  
        if(status>0){  
            response.sendRedirect("AViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}