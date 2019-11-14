package daoImpl;

import dao.DAOBase;
import dao.DiscussionDAO;
import dao.commentDAO;
import entity.Discussion;
import entity.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Comment;

public class DiscussionDAOImpl extends DAOBase implements DiscussionDAO {
    @Override
    public boolean insertDiscussion(Discussion discussion) {
        String sql="insert into discussion values(?,?,?,?)";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,discussion.getDid());
            pstmt.setString(2,discussion.getDtitle());
            pstmt.setString(3,discussion.getDtime());
            pstmt.setString(4,discussion.getDcontent());
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDiscussion(Discussion discussion) {
        String sql="update discussion set dtitle=?,dtime=?,dcontent=? where did=?";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(4,discussion.getDid());
            pstmt.setString(1,discussion.getDtitle());
            pstmt.setString(2,discussion.getDtime());
            pstmt.setString(3,discussion.getDcontent());
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDiscussion(int did) {
        String sql="delete from discussion where did=?";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,did);
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Discussion getDiscussion(int did) {
        String sql="select * from discussion where did=\'"+did+"\'";
        Statement stmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            Discussion discussion=new Discussion();
            while(rs.next()) {
            	discussion.setDid(rs.getInt("did"));
            	discussion.setDtitle(rs.getString("dtitle"));
            	discussion.setDtime(rs.getString("dtime"));
            	discussion.setDcontent(rs.getString("dcontent"));
            }
                           
        
            closeConnection(conn,stmt,rs);
            return discussion;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Discussion> getDiscussions() {
        String sql="select * from discussion";
        Statement stmt=null;
        Connection conn=null;
        ArrayList<Discussion> discussions=new ArrayList<Discussion>();
        try{
            conn=getConnection();
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
            	Discussion discussion=new Discussion();
            	discussion.setDid(rs.getInt("did"));
            	discussion.setDtitle(rs.getString("dtitle"));
            	discussion.setDtime(rs.getString("dtime"));
            	discussion.setDcontent(rs.getString("dcontent"));
                discussions.add(discussion);
            }
            closeConnection(conn,(PreparedStatement) stmt,rs);

            return discussions;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
