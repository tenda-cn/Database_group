package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOBase;
import dao.TypeDAO;
import entity.Type;

public class TypeDAOImpl extends DAOBase implements TypeDAO {

	@Override
	public boolean insert(Type type) {
		String sql = "insert into Typ values(?)";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, type.getTypename());
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean delete(String type) {
		String sql = "delete from Typ where typename = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, type);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Type get(String tp) {
		String sql = "select * from Typ where typename = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Type type = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, tp);
			rs = statement.executeQuery();
			type = new Type();
			while(rs.next()) {
				type.setTypename(rs.getString("typename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (statement != null)
					statement.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return type;
	}

	@Override
	public ArrayList<Type> getTagByMID(int mid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
