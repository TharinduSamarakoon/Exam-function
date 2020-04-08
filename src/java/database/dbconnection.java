package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
	
	
        public static Connection getConnection(){  
            Connection con=null;  
            try{  
                Class.forName("com.mysql.jdbc.Driver");  
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exams","root","");  
            }catch(Exception e){System.out.println(e);}  
            return con;  
        }  	
	
}

