package daoImpl;

import dao.DAOBase
;

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
        String sql="insert into comment values(?,?,?,?,?,?,?)";
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
            pstmt.setDouble(6, comm.getC_score());
            pstmt.setString(7, comm.getSee_movie_status());
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
        String sql="update comment set c_time=?,c_content=?,c_facility=?,useful_amount=?,c_score=?,see_movie_status=? where cid=?";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(7,comm.getCid());
            pstmt.setString(1,comm.getC_time());
            pstmt.setString(2,comm.getC_content());
            pstmt.setString(3,comm.getC_facility());            
            pstmt.setInt(4,comm.getUseful());
            pstmt.setDouble(5, comm.getC_score());
            pstmt.setString(6, comm.getSee_movie_status());
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
        String sql="select * from comment where cid=\'"+cid+"\'";
        Statement stmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            comment comm=new comment();
            while(rs.next()) {
            	comm.setCid(rs.getInt("cid"));
                comm.setC_time(rs.getString("c_time"));
                comm.setC_content(rs.getString("c_content"));
                comm.setC_facility(rs.getString("c_facility"));
                comm.setUseful(rs.getInt("useful_amount"));
                comm.setC_score(rs.getDouble("c_score"));
                comm.setSee_movie_status(rs.getString("see_movie_status"));
            }
                           
        
            closeConnection(conn,stmt,rs);
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
                comm.setC_score(rs.getDouble("c_score"));
                comm.setSee_movie_status(rs.getString("see_movie_status"));
                comms.add(comm);
            }
            closeConnection(conn,(PreparedStatement) stmt,rs);

            return comms;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public ArrayList<Integer> getComments(int mid){//获取与mid对应的所有comment的cid组成的数组
    	String sql="select cid from be_commented where mID=?";
    	Connection conn=null;
    	PreparedStatement pstmt=null;
    	ResultSet rs=null;
    	ArrayList<Integer> comms=null;
    	try {
    		conn=getConnection();
    		pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
    		rs=pstmt.executeQuery();
    		comms=new ArrayList<Integer>();
    		while(rs.next())
    		{
    			comms.add(rs.getInt("cid"));
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
				     pstmt.close();
				if(conn!=null)
					conn.close();
					
			}catch (Exception e) {
				e.printStackTrace();
			}						
		}
    	return comms;
    }
    
    @Override
    public ArrayList<comment> getByMID(ArrayList<Integer> comms,int mid)
    {//通过具体的cid数组把comment的各项信息找到
    	String sql="select * from comment where cid=?";
    	Connection conn=null;
    	PreparedStatement stmt=null;
    	ResultSet rs=null;
    	ArrayList<comment> commArray=null;
    	comment comments=null;
    	try {
			conn=getConnection();
    		stmt=conn.prepareStatement(sql);
    		commArray=new ArrayList<comment>();
    		for(int cid:comms)
    		{
    			stmt.setInt(1, cid);
    			rs=stmt.executeQuery();
    			while(rs.next())
    			{
    				comments=new comment();
    				comments.setCid(rs.getInt("cid"));
    				comments.setC_time(rs.getString("c_time"));
    				comments.setC_content(rs.getString("c_content"));
    				comments.setC_facility(rs.getString("c_facility"));
    				comments.setUseful(rs.getInt("useful_amount"));
    				comments.setC_score(rs.getDouble("c_score"));
    				comments.setSee_movie_status(rs.getString("see_movie_status"));
    				commArray.add(comments);
    			}
    		}
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
				     stmt.close();
				if(conn!=null)
					conn.close();
					
			}catch (Exception e) {
				e.printStackTrace();
			}						
		}
    	return commArray;
    }
    
    @Override
    public ArrayList<comment> getCommentByMID(int mid)//传入一个mid，直接获取与之对应的所有评价的各项信息
    {
    	ArrayList<Integer> comms=getComments(mid);
    	return getByMID(comms, mid);
    }
    
}
