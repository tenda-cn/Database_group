package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOBase;
import dao.WorkerDAO;
import entity.Worker;

public class WorkerDAOImpl extends DAOBase implements WorkerDAO {

	@Override
	public boolean insert(Worker worker) {
		String sql = "insert into Worker values(?, ?, ?)";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, worker.getWid());
			statement.setString(2, worker.getCountry());
			statement.setString(3, worker.getName());
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
	public boolean update(Worker worker) {
		String sql = "update Worker set wcountry = ?, wname = ? where wid = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, worker.getCountry());
			statement.setString(2, worker.getName());
			statement.setInt(3, worker.getWid());
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
	public boolean delete(int wid) {
		String sql = "delete from Worker where wid = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, wid);
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
	public Worker get(int wid) {
		String sql = "select * from Worker where wid = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		Worker worker = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, wid);
			rs = statement.executeQuery();
			worker = new Worker();
			while(rs.next()) {
				worker.setWid(rs.getInt("wid"));
				worker.setCountry(rs.getString("wcountry"));
				worker.setName(rs.getString("wname"));
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
		return worker;
	}
	
	private ArrayList<Integer> getDirector(int mid){
		String sql = "Select wid from direct where mID = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<Integer> workers = null;
		try { 
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, mid);
			rs = statement.executeQuery();
			workers = new ArrayList<Integer>();
			while(rs.next()) {
				workers.add(rs.getInt("wid"));
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
				e.printStackTrace();
			}
		}
		return workers;		
	}
	
	private ArrayList<Worker> getByMID(ArrayList<Integer> workers, int mid){

		String sql = "select * from Worker where wid = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<Worker> directors = null;
		Worker director = null;
		try { 
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			directors = new ArrayList<Worker>();
			for(int wid : workers) {
				statement.setInt(1, wid);
				rs = statement.executeQuery();
				while(rs.next()) {
					director = new Worker();
					director.setWid(rs.getInt("wid"));
					director.setCountry(rs.getString("wcountry"));
					director.setName(rs.getString("wname"));
					directors.add(director);
				}
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
				e.printStackTrace();
			}
		}
		return directors;
	}

	@Override
	public ArrayList<Worker> getDirectorByMID(int mid) {
		ArrayList<Integer> workers = getDirector(mid);
		return getByMID(workers, mid);
	}
	
	private ArrayList<Integer> getAuthor(int mid){
		String sql = "Select wid from author where mID = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<Integer> author = null;
		try { 
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, mid);
			rs = statement.executeQuery();
			author = new ArrayList<Integer>();
			while(rs.next()) {
				author.add(rs.getInt("wid"));
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
				e.printStackTrace();
			}
		}
		return author;
	}

	@Override
	public ArrayList<Worker> getAuthorByMID(int mid) {
		ArrayList<Integer> worker = getAuthor(mid);
		return getByMID(worker, mid);
	}

	private ArrayList<Integer> getActor(int mid){
		String sql = "Select wid from act where mID = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<Integer> actor = null;
		try { 
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, mid);
			rs = statement.executeQuery();
			actor = new ArrayList<Integer>();
			while(rs.next()) {
				actor.add(rs.getInt("wid"));
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
				e.printStackTrace();
			}
		}
		return actor;
	}
	
	@Override
	public ArrayList<Worker> getActorByMID(int mid) {
		ArrayList<Integer> workers = getActor(mid);
		return getByMID(workers, mid);
	}

}
