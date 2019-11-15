package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOBase implements DAO{
public Connection getConnection() {
    	
        Connection conn=null;
        try{
            conn=DBConnection.getConnection();
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn, PreparedStatement psmt, ResultSet rs ) {
       try {
		DBConnection.release(conn,psmt,rs);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
