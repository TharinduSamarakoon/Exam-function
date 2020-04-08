package iassignment_result;

    import java.io.IOException;  

    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
    @WebServlet("/IarEditServlet")  
    public class IarEditServlet extends HttpServlet {  
        protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
            out.println("<h1>Update Employee</h1>");  
            String sid=request.getParameter("id");  
            int id=Integer.parseInt(sid);  
              
            Iar iar=Iardb.getIAResultByIarid(id);  
              
            out.print("<form action='IarEditServlet2' method='post'>");  
            out.print("<table>");  
            out.print("<tr><td></td><td><input type='hidden' name='iarid' value='"+iar.getIarid()+"'/></td></tr>");  
            out.print("<tr><td>Index No:</td><td><input type='text' name='iarindex_no' value='"+iar.getIarindex_no()+"'/></td></tr>");  
            out.print("<tr><td>Grade:</td><td><input type='text' name='iargrade' value='"+iar.getIargrade()+"'/></td></tr>");  
            out.print("<tr><td>Subject:</td><td><input type='text' name='iarsubject' value='"+iar.getIarsubject()+"'/></td></tr>");  
           out.print("<tr><td>Subject:</td><td><input type='text' name='iarresult' value='"+iar.getIarresult()+"'/></td></tr>");
            out.print("</td></tr>");  
            out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
            out.print("</table>");  
            out.print("</form>");  
              
            out.close();  
        }  
    }  