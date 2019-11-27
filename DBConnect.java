package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {

	   public static Connection getConnection() throws Exception{
	    	Connection conn=null;
	    	
	    	//加载Sqlserver数据库驱动程序，sqljdbc4.jar可以省略本句，sqljdbc.jar不可以
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
	   
	    	//创建连接
	   	    String dburl="jdbc:sqlserver://localhost:1433;databaseName=douban";
	    	String sqlUser="cjh";
	    	String sqlPwd="123";    	
	    	conn=DriverManager.getConnection(dburl,sqlUser,sqlPwd);
	 /*
	    	//或者使用下面的dburl创建连接
	    	String dburl="jdbc:sqlserver://localhost:1433;databaseName=txdatabase;user=sa;password=123";
	    	conn=DriverManager.getConnection(dburl);
	 */   	
	    	return conn;
	    }
		
	    //释放资源
	    public static void release(Connection conn,Statement psmt,ResultSet rs)
	    {
	          try {
	        	  if(rs!=null)
	        		 rs.close();
	        	  if(psmt!=null)
				     psmt.close();
	        	  if(conn!=null)
		          conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	      }
	 

	
}
