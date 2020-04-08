package exam_result;

    import java.util.*;  

    import java.sql.*; 

    import database.dbconnection;
    public class Erdb {   

        public static int save(Er er){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "insert into exam_result(ertitle,ergrade,erfile) values (?,?,?)");  
                ps.setString(1,er.getErtitle());  
                ps.setString(2,er.getErgrade());  
                ps.setString(3,er.getErfile());  
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int update(Er er){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "update exam_result set ertitle=?,ergrade=?,erfile=? where erid=?");  
                ps.setString(1,er.getErtitle());  
                ps.setString(2,er.getErgrade());  
                ps.setString(3,er.getErfile());  
                ps.setInt(4,er.getErid());  
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int delete(int erid){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("delete from exam_result where erid=?");  
                ps.setInt(1,erid);  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return status;  
        }  
        public static Er getEResultByErid(int erid){  
            Er er=new Er();  
              
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from exam_result where erid=?");  
                ps.setInt(1,erid);  
                ResultSet rs=ps.executeQuery();  
                if(rs.next()){  
                    er.setErid(rs.getInt(1));  
                    er.setErtitle(rs.getString(2));  
                    er.setErgrade(rs.getString(3));  
                    er.setErfile(rs.getString(4));  
                   
                }  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return er;  
        }  
        public static List<Er> getAllErResults(){  
            List<Er> list=new ArrayList<Er>();  
              
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from exam_result");  
                ResultSet rs=ps.executeQuery();  
                while(rs.next()){  
                    Er er=new Er();  
                    er.setErid(rs.getInt(1));  
                    er.setErtitle(rs.getString(2));  
                    er.setErgrade(rs.getString(3));  
                    er.setErfile(rs.getString(4));  
                    list.add(er);  
                }  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return list;  
        }  
    }  