package assignment_result;

import java.io.IOException;
  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ArViewServlet")  
public class ArViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<Ar> list=Ardb.getAllAResults();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Title</th><th>Grade</th><th>File</th> <th>Edit</th><th>Delete</th></tr>");  
        for(Ar ar:list){  
         out.print("<tr><td>"+ar.getArid()+"</td><td>"+ar.getArtitle()+"</td><td>"+ar.getArgarde()+"</td><td>"+ar.getArfile()+"</td> <td><a href='ArEditServlet?arid="+ar.getArid()+"'>edit</a></td>  <td><a href='ArDeleteServlet?arid="+ar.getArid()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}