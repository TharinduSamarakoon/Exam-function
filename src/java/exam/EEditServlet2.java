package exam;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EEditServlet2")  
public class EEditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String pid=request.getParameter("eid");  
        int eid=Integer.parseInt(pid);  
        String egrade=request.getParameter("egrade");  
        String esubject=request.getParameter("esubject");  
        String elink=request.getParameter("elink");   
          
        E e=new E();  
        e.setEid(eid);  
        e.setEgrade(egrade);  
        e.setEsubject(esubject);  
        e.setElink(elink);  
          
        int status=Edb.update(e);  
        if(status>0){  
            response.sendRedirect("EViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}