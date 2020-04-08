package assignment;

    import java.util.*;  

    import java.sql.*;  

    import database.dbconnection;
      
    public class Adb {   

        public static int save(A a){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "insert into assignment(atitle,agrade,afile) values (?,?,?)");  
                ps.setString(1,a.getAtitle());  
                ps.setString(2,a.getAgrade());  
                ps.setString(3,a.getAfile());  
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int update(A a){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "update assignment set atitle=?,agrade=?,afile=?, where aid=?");  
                ps.setString(1,a.getAtitle());  
                ps.setString(2,a.getAgrade());  
                ps.setString(3,a.getAfile());  
                ps.setInt(4,a.getAid());  
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int delete(int aid){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("delete from assignment where aid=?");  
                ps.setInt(1,aid);  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return status;  
        }  
        public static A getAssignmentByAid(int aid){  
            A a=new A();  
              
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from assignment where aid=?");  
                ps.setInt(1,aid);  
                ResultSet rs=ps.executeQuery();  
                if(rs.next()){  
                    a.setAid(rs.getInt(1));  
                    a.setAtitle(rs.getString(2));  
                    a.setAgrade(rs.getString(3));  
                    a.setAfile(rs.getString(4));   
                }  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return a;  
        }  
        public static List<A> getAllAssignments(){  
            List<A> list=new ArrayList<A>();  
              
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from assignment");  
                ResultSet rs=ps.executeQuery();  
                while(rs.next()){  
                    A a=new A();  
                    a.setAid(rs.getInt(1));  
                    a.setAtitle(rs.getString(2));  
                    a.setAgrade(rs.getString(3));  
                    a.setAfile(rs.getString(4));   
                    list.add(a);  
                }  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return list;  
        }  
    }  