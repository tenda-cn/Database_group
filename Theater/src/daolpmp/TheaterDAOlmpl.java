package daolpmp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.DAOBase;
import dao.TheaterDAO;
import entity.Theater;


public class TheaterDAOlmpl extends DAOBase implements TheaterDAO{
	public boolean insertTheater(Theater theater) {
        String sql="insert into Theater values(?,?,?)";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
        	conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,theater.gettID());
            pstmt.setString(2,theater.gettName());
            pstmt.setString(3,theater.gettLocation());
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTheater(Theater theater) {
        String sql="update Theater set tName=?,tLocation=? where tID=? ";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt.setString(2,theater.gettName());
            pstmt.setString(3,theater.gettLocation());
            pstmt.setFloat(1,theater.gettID());
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTheater(int tID) {
        String sql="delete from Theater where tID=?";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,tID);
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Theater getTheater(int tID) {
        String sql="select * from Theater where tID=\'"+tID+"\'";
        Statement stmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            Theater theater=new Theater();
            while (rs.next()){
            	theater.settID(rs.getInt(0));
            	theater.settName(rs.getString("tName"));
            	theater.settLocation(rs.getString("tLocation"));
            }
            closeConnection(conn,(PreparedStatement) stmt,rs);
            return theater;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Theater> getTheaters() {
        String sql="select * from Theater";
        Statement stmt=null;
        Connection conn=null;
        ArrayList<Theater> theaters=new ArrayList<Theater>();
        try{
            conn=getConnection();
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
            	Theater theater=new Theater();
            	theater.settID(rs.getInt(0));
            	theater.settName(rs.getString("tName"));
            	theater.settLocation(rs.getString("tLocation"));

            	theaters.add(theater);
            }
            closeConnection(conn,(PreparedStatement) stmt,rs);

            return theaters;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
