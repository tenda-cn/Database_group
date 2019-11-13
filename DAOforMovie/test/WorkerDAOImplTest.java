package test;

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
	
	public static void main(String[] args) {
		//testInsert();
		//testUpdate();
		//testGet();
		testDelete();
	}
}
