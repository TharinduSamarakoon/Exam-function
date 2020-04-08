package iassignment_result;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/IarEditServlet2")  
public class IarEditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String nid=request.getParameter("iarid");  
        int iarid=Integer.parseInt(nid);  
        String iarindex_no=request.getParameter("iarindex_no");  
        String iargrade=request.getParameter("iargrade");  
        String iarsubject=request.getParameter("iarsubject");  
        String iarresult=request.getParameter("iarresult");  
          
        Iar iar=new Iar();  
        iar.setIarid(iarid);  
        iar.setIarindex_no(iarindex_no);  
        iar.setIargrade(iargrade);  
        iar.setIarsubject(iarsubject);  
        iar.setIarresult(iarresult);  
          
        int status=Iardb.update(iar);  
        if(status>0){  
            response.sendRedirect("IarViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}