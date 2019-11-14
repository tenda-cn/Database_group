package daoImpl;

import dao.DAOBase;
import dao.commentDAO;
import entity.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Comment;

public class commentDAOImpl extends DAOBase implements commentDAO {
    @Override
    public boolean insertComment(comment comm) {
        String sql="insert into user values(?,?,?,?,?)";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,comm.getCid());
            pstmt.setString(2,comm.getC_time());
            pstmt.setString(3,comm.getC_content());
            pstmt.setString(4,comm.getC_facility());
            pstmt.setInt(5,comm.getUseful());
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateComment(comment comm) {
        String sql="update comment set c_time=?,c_content=?,c_facility=?,useful_amount=? where cid=?";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(5,comm.getCid());
            pstmt.setString(1,comm.getC_time());
            pstmt.setString(2,comm.getC_content());
            pstmt.setString(3,comm.getC_facility());
            pstmt.setInt(4,comm.getUseful());
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteComment(int cid) {
        String sql="delete from comment where cid=?";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,cid);
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public comment getComment(int cid) {
        String sql="select * from user where uid=\'"+cid+"\'";
        Statement stmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            comment comm=new comment();
            while (rs.next()){
                comm.setCid(rs.getInt(cid));
                comm.setC_time(rs.getString("c_time"));
                comm.setC_content(rs.getString("c_content"));
                comm.setC_facility(rs.getString("c_facility"));
                comm.setUseful(rs.getInt("useful_amount"));               
            }
            closeConnection(conn,(PreparedStatement) stmt,rs);
            return comm;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<comment> getComment() {
        String sql="select * from user";
        Statement stmt=null;
        Connection conn=null;
        ArrayList<comment> comms=new ArrayList<comment>();
        try{
            conn=getConnection();
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
                comment comm=new comment();
                comm.setCid(rs.getInt("cid"));
                comm.setC_time(rs.getString("c_time"));
                comm.setC_content(rs.getString("c_content"));
                comm.setC_facility(rs.getString("c_facility"));
                comm.setUseful(rs.getInt("useful_amount")); 
                comms.add(comm);
            }
            closeConnection(conn,(PreparedStatement) stmt,rs);

            return comms;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
