package assignment;

    import java.io.IOException;  

    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    @WebServlet("/AEditServlet")  
    public class AEditServlet extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
            out.println("<h1>Update Employee</h1>");  
            String kid=request.getParameter("aid");  
            int aid=Integer.parseInt(kid);  
              
            A a=Adb.getAssignmentByAid(aid);  
              
            out.print("<form action='AEditServlet2' method='post'>");  
            out.print("<table>");  
            out.print("<tr><td></td><td><input type='hidden' name='id' value='"+a.getAid()+"'/></td></tr>");  
            out.print("<tr><td>Title:</td><td><input type='text' name='atitle' value='"+a.getAtitle()+"'/></td></tr>");  
            out.print("<tr><td>Grade:</td><td><input type='text' name='agrade' value='"+a.getAgrade()+"'/></td></tr>");  
            out.print("<tr><td>File:</td><td><input type='file' name='afile' value='"+a.getAfile()+"'/></td></tr>");   
            out.print("</td></tr>");  
            out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
            out.print("</table>");  
            out.print("</form>");  
              
            out.close();  
        }  
    }  
