package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOBase;
import dao.MovieDAO;
import entity.Movie;

public class MovieDAOImpl extends DAOBase implements MovieDAO {

	@Override
	public boolean insert(Movie movie) {
		String sql = "insert into Movie values(?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, movie.getmID());
			statement.setString(2, movie.getMname());
			statement.setString(3, movie.getMovieLanguage());
			statement.setString(4, movie.getDuration());
			statement.setString(5, movie.getArea());
			statement.setString(6, movie.getReleaseTime());
			statement.setString(7, movie.getOtherName());
			statement.setString(8, movie.getContent());
			statement.setDouble(9, movie.getPrice());
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
	public boolean update(Movie movie) {
		String sql = "update Movie set mname = ?, movieLanguage = ?,"
				+ "duration = ?, area = ?, releaseTime = ?, " + 
				"otherName = ?, content = ?, price = ? where mID = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, movie.getMname());
			statement.setString(2, movie.getMovieLanguage());
			statement.setString(3, movie.getDuration());
			statement.setString(4, movie.getArea());
			statement.setString(5, movie.getReleaseTime());
			statement.setString(6, movie.getOtherName());
			statement.setString(7, movie.getContent());
			statement.setDouble(8, movie.getPrice());
			statement.setInt(9, movie.getmID());
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
	public boolean delete(int mID) {
		String sql = "delete from Movie where mID = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, mID);
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
	public Movie get(int mID) {
		String sql = "select * from Movie where mID = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Movie movie = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, mID);
			rs = statement.executeQuery();
			movie = new Movie();
			while (rs.next()) {
				movie.setmID(rs.getInt("mID"));
				movie.setMname(rs.getString("mname"));
				movie.setMovieLanguage(rs.getString("movieLanguage"));
				movie.setDuration(rs.getString("duration"));
				movie.setArea(rs.getString("releaseTime"));
				movie.setOtherName(rs.getString("othername"));
				movie.setContent(rs.getString("content"));
				movie.setPrice(rs.getDouble("price"));
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
		return movie;
	}

	@Override
	public ArrayList<Movie> getALL() {
		// TODO Auto-generated method stub
		return null;
	}
}
