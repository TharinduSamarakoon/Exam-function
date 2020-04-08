package exam;

import java.io.IOException;
  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/EViewServlet")  
public class EViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='exam.html'>Add New Exam</a>");  
        out.println("<h1>Exams List</h1>");  
          
        List<E> list=Edb.getAllExams();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Grade</th><th>Subject</th><th>Link</th> <th>Edit</th><th>Delete</th></tr>");  
        for(E e:list){  
         out.print("<tr><td>"+e.getEid()+"</td><td>"+e.getEgrade()+"</td><td>"+e.getEsubject()+"</td><td>"+e.getElink()+"</td><td><a href='EEditServlet?eid="+e.getEid()+"'>edit</a></td>  <td><a href='EDeleteServlet?eid="+e.getEid()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}
