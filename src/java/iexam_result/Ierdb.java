package iexam_result;

    import java.util.*;  

    import java.sql.*;  

    import database.dbconnection;
      
    public class Ierdb {   
        
        public static int save(Ier ier){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "insert into individual_exam_result(ierindex_no,iergrade,iersubject,ierresult) values (?,?,?,?)");  
                ps.setString(1,ier.getIerindex_no());  
                ps.setString(2,ier.getIergrade());  
                ps.setString(3,ier.getIersubject());  
                ps.setString(4,ier.getIerresult());  
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int update(Ier ier){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "update individual_exam_result set ierindex_no=?,iergrade=?,iersubject=?,ierlink=? where ierid=?");  
                ps.setString(1,ier.getIerindex_no());  
                ps.setString(2,ier.getIergrade());  
                ps.setString(3,ier.getIersubject());  
                ps.setString(4,ier.getIerresult());  
                ps.setInt(5,ier.getIerid());  
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int delete(int ierid){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("delete from individual_exam_result where ierid=?");  
                ps.setInt(1,ierid);  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return status;  
        }  
        public static Ier getIEResultByIerid(int ierid){  
            Ier ier=new Ier();  
              
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from individual_exam_result where id=?");  
                ps.setInt(1,ierid);  
                ResultSet rs=ps.executeQuery();  
                if(rs.next()){  
                    ier.setIerid(rs.getInt(1));  
                    ier.setIerindex_no(rs.getString(2));  
                    ier.setIergrade(rs.getString(3));  
                    ier.setIersubject(rs.getString(4));  
                    ier.setIerresult(rs.getString(5));  
                }  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return ier;  
        }  
        public static List<Ier> getAllIEresults(){  
            List<Ier> list=new ArrayList<Ier>();  
              
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from individual_exam_result");  
                ResultSet rs=ps.executeQuery();  
                while(rs.next()){  
                    Ier ier=new Ier();  
                    ier.setIerid(rs.getInt(1));  
                    ier.setIerindex_no(rs.getString(2));  
                    ier.setIergrade(rs.getString(3));  
                    ier.setIersubject(rs.getString(4));  
                    ier.setIerresult(rs.getString(5));  
                    list.add(ier);  
                }  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return list;  
        }  
    }  