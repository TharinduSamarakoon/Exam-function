package assignment;

import java.io.IOException;
  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/AViewServlet")  
public class AViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='assignment.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<A> list=Adb.getAllAssignments();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Title</th><th>Grade</th><th>File</th> <th>Edit</th><th>Delete</th></tr>");  
        for(A a:list){  
         out.print("<tr><td>"+a.getAid()+"</td><td>"+a.getAtitle()+"</td><td>"+a.getAgrade()+"</td><td>"+a.getAfile()+"</td><td><a href='AEditServlet?aid="+a.getAid()+"'>edit</a></td>  <td><a href='ADeleteServlet?aid="+a.getAid()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}