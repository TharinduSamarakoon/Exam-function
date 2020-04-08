package assignment_result;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ArEditServlet2")  
public class ArEditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String lid=request.getParameter("arid");  
        int arid=Integer.parseInt(lid);  
        String artitle=request.getParameter("artitle");  
        String argrade=request.getParameter("argrade");  
        String arfile=request.getParameter("arfile");  
          
        Ar ar=new Ar();  
        ar.setArid(arid);  
        ar.setArtitle(artitle);  
        ar.setArgrade(argrade);  
        ar.setArfile(arfile);  

          
        int status=Ardb.update(ar);  
        if(status>0){  
            response.sendRedirect("ArViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}