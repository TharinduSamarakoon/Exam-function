package assignment_result;

    import java.io.IOException;  

    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    @WebServlet("/ArEditServlet")  
    public class ArEditServlet extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
            out.println("<h1>Update Employee</h1>");  
            String lid=request.getParameter("arid");  
            int arid=Integer.parseInt(lid);  
              
            Ar ar=Ardb.getAResultByArid(arid);  
              
            out.print("<form action='ArEditServlet2' method='post'>");  
            out.print("<table>");  
            out.print("<tr><td></td><td><input type='hidden' name='arid' value='"+ar.getArid()+"'/></td></tr>");  
            out.print("<tr><td>Title:</td><td><input type='text' name='artitle' value='"+ar.getArtitle()+"'/></td></tr>");   
            out.print("<tr><td>Grade:</td><td><input type='text' name='argarde' value='"+ar.getArgarde()+"'/></td></tr>"); 
            out.print("<tr><td>File:</td><td><input type='file' name='arfile' value='"+ar.getArfile()+"'/></td></tr>"); 
            out.print("</td></tr>");  
            out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
            out.print("</table>");  
            out.print("</form>");  
              
            out.close();  
        }  
    }  