package iexam_result;

import java.io.IOException;
  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/IerViewServlet")  
public class IerViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='mainUI.html'>Add New Exam Results</a>");  
        out.println("<h1>Exam Result List</h1>");  
          
        List<Ier> list=Ierdb.getAllIEresults();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Index No</th><th>Grade</th><th>Subject</th><th>Result</th> <th>Edit</th><th>Delete</th></tr>");  
        for(Ier ier:list){  
         out.print("<tr><td>"+ier.getIerid()+"</td><td>"+ier.getIerindex_no()+"</td><td>"+ier.getIergrade()+"</td><td>"+ier.getIersubject()+"</td><td>"+ier.getIerresult()+"</td><td><a href='IerEditServlet?iarid="+ier.getIerid()+"'>edit</a></td>  <td><a href='IerDeleteServlet?iarid="+ier.getIerid()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}