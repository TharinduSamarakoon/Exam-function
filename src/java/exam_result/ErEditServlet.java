package exam_result;

    import java.io.IOException;  

    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    @WebServlet("/ErEditServlet")  
    public class ErEditServlet extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
            out.println("<h1>Update Employee</h1>");  
            String sid=request.getParameter("id");  
            int id=Integer.parseInt(sid);  
              
            Er er=Erdb.getEResultByErid(id);  
              
            out.print("<form action='ErEditServlet2' method='post'>");  
            out.print("<table>");  
            out.print("<tr><td></td><td><input type='hidden' name='erid' value='"+er.getErid()+"'/></td></tr>");  
            out.print("<tr><td>Title:</td><td><input type='text' name='ertitle' value='"+er.getErtitle()+"'/></td></tr>");  
            out.print("<tr><td>Grade:</td><td><input type='text' name='ergrade' value='"+er.getErgrade()+"'/></td></tr>");  
            out.print("<tr><td>File:</td><td><input type='file' name='erfile' value='"+er.getErfile()+"'/></td></tr>");  
            out.print("</td></tr>");  
            out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
            out.print("</table>");  
            out.print("</form>");  
              
            out.close();  
        }  
    }  