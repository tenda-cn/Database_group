package dao;

import java.util.ArrayList;

import entity.Worker;

public interface WorkerDAO {
	public boolean insert(Worker worker);
	public boolean update(Worker worker);
	public boolean delete(int wid);
	public Worker get(int wid);
	public ArrayList<Worker> getDirectorByMID(int mid);
	public ArrayList<Worker> getAuthorByMID(int mid);
	public ArrayList<Worker> getActorByMID(int mid);
}
