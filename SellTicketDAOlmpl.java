package daolmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.DAOBase;
import dao.SellTicketDAO;
import entity.SellTicket;

public class SellTicketDAOlmpl extends DAOBase implements SellTicketDAO{
	public boolean insertSellTicket(SellTicket sellTicket) {
        String sql="insert into SellTicket values(?,?,?)";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
        	conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,sellTicket.getmID());
            pstmt.setInt(2,sellTicket.getTid());
            pstmt.setFloat(3,sellTicket.getTicketPrice());
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSellTicket(SellTicket sellTicket) {
        String sql="update SellTicket set mID=?,ticketPrice=? where tid=? ";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt.setInt(1,sellTicket.getmID());
            pstmt.setFloat(3,sellTicket.getTicketPrice());
            pstmt.setInt(2,sellTicket.getTid());
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSellTicket(int tid) {
        String sql="delete from SellTicket where tid=?";
        PreparedStatement pstmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(2,tid);
            pstmt.executeUpdate();
            closeConnection(conn,pstmt,null);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public SellTicket getSellTicket(int tid) {
        String sql="select * from SellTicket where tid=\'"+tid+"\'";
        Statement stmt=null;
        Connection conn=null;
        try{
            conn=getConnection();
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            SellTicket sellTicket=new SellTicket();
            while (rs.next()){
            	sellTicket.setmID(rs.getInt(0));
            	sellTicket.setTid(rs.getInt(0));
            	sellTicket.setTicketPrice(rs.getFloat(0));
            }
            closeConnection(conn,(PreparedStatement) stmt,rs);
            return sellTicket;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<SellTicket> getSellTickets() {
        String sql="select * from SellTicket";
        Statement stmt=null;
        Connection conn=null;
        ArrayList<SellTicket> sellTickets=new ArrayList<SellTicket>();
        try{
            conn=getConnection();
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while (rs.next()){
            	SellTicket sellTicket=new SellTicket();
            	sellTicket.setmID(rs.getInt(0));
            	sellTicket.setTid(rs.getInt(0));
            	sellTicket.setTicketPrice(rs.getFloat(0));

            	sellTickets.add(sellTicket);
            }
            closeConnection(conn,(PreparedStatement) stmt,rs);

            return sellTickets;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
