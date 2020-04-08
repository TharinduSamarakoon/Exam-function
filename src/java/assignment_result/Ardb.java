package assignment_result;

    import java.util.*;  

    import java.sql.*; 

    import database.dbconnection;
      
    public class Ardb {   

        public static int save(Ar ar){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "insert into assignment_result(artitle,argrade,arfile) values (?,?,?)");  
                ps.setString(1,ar.getArtitle());  
                ps.setString(2,ar.getArgarde());  
                ps.setString(3,ar.getArfile());   
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int update(Ar ar){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "update assignment_result set artitle=?,argrade=?,arfile=? where arid=?");  
                ps.setString(1,ar.getArtitle());  
                ps.setString(2,ar.getArgarde());  
                ps.setString(3,ar.getArfile());   
                ps.setInt(4,ar.getArid());  
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int delete(int arid){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("delete from assignment_result where arid=?");  
                ps.setInt(1,arid);  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return status;  
        }  
        public static Ar getAResultByArid(int arid){  
            Ar ar=new Ar();  
              
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from assignment_result where arid=?");  
                ps.setInt(1,arid);  
                ResultSet rs=ps.executeQuery();  
                if(rs.next()){  
                    ar.setArid(rs.getInt(1));  
                    ar.setArtitle(rs.getString(2));  
                    ar.setArgrade(rs.getString(3));  
                    ar.setArfile(rs.getString(4));    
                }  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return ar;  
        }  
        public static List<Ar> getAllAResults(){  
            List<Ar> list=new ArrayList<Ar>();  
              
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from assignment_result");  
                ResultSet rs=ps.executeQuery();  
                while(rs.next()){  
                    Ar ar=new Ar();  
                    ar.setArid(rs.getInt(1));  
                    ar.setArtitle(rs.getString(2));  
                    ar.setArgrade(rs.getString(3));  
                    ar.setArfile(rs.getString(4));  
                    list.add(ar);  
                }  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return list;  
        }  
    }  