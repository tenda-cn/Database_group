package test;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.WorkerDAO;
import daoImpl.WorkerDAOImpl;
import entity.Worker;

public class WorkerDAOImplTest {
	static Worker worker = new Worker();
	static WorkerDAOImpl workerDAO = (WorkerDAOImpl) DAOFactory.getWorkerDAO();

	protected static void testInsert() {
		worker.setWid(1);
		worker.setCountry("china");
		worker.setName("dzy");
		workerDAO.insert(worker);
	}

	protected static void testUpdate() {
		worker.setWid(1);
		worker.setCountry("china");
		worker.setName("dzydzy7");
		workerDAO.update(worker);
	}

	protected static void testGet() {
		worker = workerDAO.get(1);
		System.out.println(worker.getName());
	}

	protected static void testDelete() {
		workerDAO.delete(1);
	}

	protected static void testGetDirector() {
		ArrayList<Worker> directors = workerDAO.getDirectorByMID(1);
		for (Worker d : directors) {
			System.out.println(d.getName());
		}
	}
	
	protected static void testGetAuthor() {
		ArrayList<Worker> author = workerDAO.getAuthorByMID(1);
		for(Worker a : author) {
			System.out.println(a.getName());
		}
	}
	
	protected static void testGetActor() {
		ArrayList<Worker> actor = workerDAO.getActorByMID(1);
		for (Worker a : actor) {
			System.out.println(a.getName());
		}
	}

	public static void main(String[] args) {
		// testInsert();
		// testUpdate();
		// testGet();
		// testDelete();
		testGetDirector();
		testGetAuthor();
		testGetActor();
	}
}
