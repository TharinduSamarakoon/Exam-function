package exam;

    import java.io.IOException;  

    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    @WebServlet("/EEditServlet")  
    public class EEditServlet extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
            out.println("<h1>Update Exam</h1>");  
            String pid=request.getParameter("eid");  
            int eid=Integer.parseInt(pid);  
              
            E e=Edb.getExamByEid(eid);  
              
            out.print("<form action='EEditServlet2' method='post'>");  
            out.print("<table>");  
            out.print("<tr><td></td><td><input type='hidden' name='eid' value='"+e.getEid()+"'/></td></tr>");  
            out.print("<tr><td>Name:</td><td><input type='text' name='egrade' value='"+e.getEgrade()+"'/></td></tr>");  
            out.print("<tr><td>Password:</td><td><input type='text' name='esubject' value='"+e.getEsubject()+"'/></td></tr>");  
            out.print("<tr><td>Email:</td><td><input type='text' name='elink' value='"+e.getElink()+"'/></td></tr>");   
            out.print("</td></tr>");  
            out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
            out.print("</table>");  
            out.print("</form>");  
              
            out.close();  
        }  
    }  