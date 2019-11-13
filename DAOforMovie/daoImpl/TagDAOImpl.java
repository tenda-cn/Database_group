package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOBase;
import dao.TagDAO;
import entity.Tag;

public class TagDAOImpl extends DAOBase implements TagDAO {

	@Override
	public boolean insert(Tag tag) {
		String sql = "insert into tag values(?)";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, tag.getTag());
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
	public boolean delete(String tag) {
		String sql = "delete from tag where tag = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, tag);
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
	public Tag get(String stag) {
		String sql = "select * from tag where tag = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Tag tag = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, stag);
			rs = statement.executeQuery();
			tag = new Tag();
			while(rs.next()) {
				tag.setTag(rs.getString("tag"));
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
		return tag;
	}

	@Override
	public ArrayList<Tag> getTagByMID(int mid) {
		// TODO Auto-generated method stub
		return null;
	}

}
