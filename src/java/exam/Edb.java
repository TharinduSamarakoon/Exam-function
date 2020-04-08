package exam;

    import java.util.*;  

    import java.sql.*; 

    import database.dbconnection;
      
    public class Edb {   
         
        public static int save(E e){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "insert into exam(egrade,esubject,elink) values (?,?,?)");  
                ps.setString(1,e.getEgrade());  
                ps.setString(2,e.getEsubject());  
                ps.setString(3,e.getElink());  
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int update(E e){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement(  
                             "update exam set egrade=?,esubject=?,elink=? where eid=?");  
                ps.setString(1,e.getEgrade());  
                ps.setString(2,e.getEsubject());  
                ps.setString(3,e.getElink());  
                ps.setInt(4,e.getEid());  
                  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return status;  
        }  
        public static int delete(int eid){  
            int status=0;  
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("delete from exam where eid=?");  
                ps.setInt(1,eid);  
                status=ps.executeUpdate();  
                  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return status;  
        }  
        public static E getExamByEid(int eid){  
            E e=new E();  
              
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from exam where eid=?");  
                ps.setInt(1,eid);  
                ResultSet rs=ps.executeQuery();  
                if(rs.next()){  
                    e.setEid(rs.getInt(1));  
                    e.setEgrade(rs.getString(2));  
                    e.setEsubject(rs.getString(3));  
                    e.setElink(rs.getString(4));   
                }  
                con.close();  
            }catch(Exception ex){ex.printStackTrace();}  
              
            return e;  
        }  
        public static List<E> getAllExams(){  
            List<E> list=new ArrayList<E>();  
              
            try{  
                Connection con=dbconnection.getConnection();  
                PreparedStatement ps=con.prepareStatement("select * from exam");  
                ResultSet rs=ps.executeQuery();  
                while(rs.next()){  
                    E e=new E();  
                    e.setEid(rs.getInt(1));  
                    e.setEgrade(rs.getString(2));  
                    e.setEsubject(rs.getString(3));  
                    e.setElink(rs.getString(4));  
                    list.add(e);  
                }  
                con.close();  
            }catch(Exception e){e.printStackTrace();}  
              
            return list;  
        }  
    }  

