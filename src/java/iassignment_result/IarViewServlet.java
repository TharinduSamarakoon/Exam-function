package iassignment_result;

import java.io.IOException;
  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/IarViewServlet")  
public class IarViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
        out.println(""); 
        List<Iar> list=Iardb.getAllIAResults();  
          
        out.print("<table border='1' width='100%'"); 
        out.print("<tr><th>Id</th><th>Index_no</th><th>Grade</th><th>Subject</th><th>Result</th> <th>Edit</th><th>Delete</th></tr>");  
        for(Iar iar:list){  
         out.print("<tr><td>"+iar.getIarid()+"</td><td>"+iar.getIarindex_no()+"</td><td>"+iar.getIargrade()+"</td><td>"+iar.getIarsubject()+"</td><td>"+iar.getIarresult()+"</td><td><a href='IarEditServlet?iarid="+iar.getIarid()+"'>edit</a></td>  <td><a href='IarDeleteServlet?iarid="+iar.getIarid()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}