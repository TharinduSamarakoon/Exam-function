package iassignment_result;

    import java.util.*;  

    import java.sql.*; 

    import database.dbconnection;
      
    public class Iardb {   
         
        public static int save(Iar iar){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "insert into individual_assignment_result(iarindex_no,iargrade,iarsubject,iarresult) values (?,?,?,?)");  
                ps.setString(1,iar.getIarindex_no());  
                ps.setString(2,iar.getIargrade());  
                ps.setString(3,iar.getIarsubject());  
                ps.setString(4,iar.getIarresult());  
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int update(Iar iar){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "update individual_assignment_result set iarindex_no=?,iargrade=?,iarsubject=?,iarresult=? where iarid=?");  
                ps.setString(1,iar.getIarindex_no());  
                ps.setString(2,iar.getIargrade());  
                ps.setString(3,iar.getIarsubject());  
                ps.setString(4,iar.getIarresult());  
                ps.setInt(5,iar.getIarid());  
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int delete(int iarid){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("delete from individual_assignment_result where iarid=?");  
                ps.setInt(1,iarid);  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return status;  
        }  
        public static Iar getIAResultByIarid(int iarid){  
            Iar iar=new Iar();  
              
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from individual_assignment_result where iarid=?");  
                ps.setInt(1,iarid);  
                ResultSet rs=ps.executeQuery();  
                if(rs.next()){  
                    iar.setIarid(rs.getInt(1));  
                    iar.setIarindex_no(rs.getString(2));  
                    iar.setIargrade(rs.getString(3));  
                    iar.setIarsubject(rs.getString(4));  
                    iar.setIarresult(rs.getString(5));  
                }  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return iar;  
        }  
        public static List<Iar> getAllIAResults(){  
            List<Iar> list=new ArrayList<Iar>();  
              
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from individual_assignment_result");  
                ResultSet rs=ps.executeQuery();  
                while(rs.next()){  
                    Iar iar=new Iar();  
                    iar.setIarid(rs.getInt(1));  
                    iar.setIarindex_no(rs.getString(2));  
                    iar.setIargrade(rs.getString(3));  
                    iar.setIarsubject(rs.getString(4));  
                    iar.setIarresult(rs.getString(5));  
                    list.add(iar);  
                }  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return list;  
        }  
    }  