package exam_result;

import java.io.IOException;
  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ErViewServlet")  
public class ErViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='mainUI.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<Er> list=Erdb.getAllErResults();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Title</th><th>Grade</th><th>File</th> <th>Edit</th><th>Delete</th></tr>");  
        for(Er er:list){  
         out.print("<tr><td>"+er.getErid()+"</td><td>"+er.getErtitle()+"</td><td>"+er.getErgrade()+"</td><td>"+er.getErfile()+"</td><td><a href='ErEditServlet?erid="+er.getErid()+"'>edit</a></td>  <td><a href='ErDeleteServlet?erid="+er.getErid()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}