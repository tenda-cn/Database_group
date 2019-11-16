package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.DAOBase;
import dao.PriceDAO;
import entity.Discussion;
import entity.Price;

public class PriceDaoImpl extends DAOBase implements PriceDAO  {

	@Override
	public boolean insertPrice(Price price) {
		String sql="insert into price values(?,?,?)";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,price.getPId());
            pstmt.setString(2,price.getFestival());
            pstmt.setString(3,price.getFestival());
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean updatePrice(Price pricer) {
		 String sql="update price set pfestival=?,pitem=? where did=?";
	        PreparedStatement pstmt=null;
	        Connection conn=null;
	        try{
	            conn=getConnection();
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setInt(3,pricer.getPId());
	            pstmt.setString(1,pricer.getFestival());
	            pstmt.setString(2,pricer.getItem()); 
	            pstmt.executeUpdate();
	            closeConnection(conn,pstmt,null);
	            return true;
	        }catch (Exception e){
	            e.printStackTrace();
	            return false;
	        }
	}

	@Override
	public boolean deletePrice(int pid) {
		 String sql="delete from price where pid=?";
	        PreparedStatement pstmt=null;
	        Connection conn=null;
	        try{
	            conn=getConnection();
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setInt(1,pid);
	            pstmt.executeUpdate();
	            closeConnection(conn,pstmt,null);
	            return true;
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return false;
	}

	@Override
	public Price getPrice(int pid) {
		 String sql="select * from price where pid=\'"+pid+"\'";
	        Statement stmt=null;
	        Connection conn=null;
	        try{
	            conn=getConnection();
	            stmt=conn.createStatement();
	            ResultSet rs=stmt.executeQuery(sql);
	           Price price=new Price();
	            while(rs.next()) {
	            	price.setPId(rs.getInt("pid"));
	            	price.setFestival(rs.getString("pfestival"));
	            	price.setItem(rs.getString("pitem"));
	            }
	                           
	        
	            closeConnection(conn,stmt,rs);
	            return price;
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return null;
	}


}
