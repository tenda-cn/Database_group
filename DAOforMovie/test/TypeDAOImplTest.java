package test;

import java.util.ArrayList;

import dao.DAOFactory;
import daoImpl.TypeDAOImpl;
import entity.Type;

public class TypeDAOImplTest {
	static Type type = new Type();
	static TypeDAOImpl typeDAO = (TypeDAOImpl) DAOFactory.getTypeDAO();
	
	protected static void testInsert() {
		type.setTypename("类别");
		typeDAO.insert(type);
	}
	
	protected static void testGet() {
		System.out.println(typeDAO.get("类别").getTypename());
	}
	
	protected static void testDelete() {
		typeDAO.delete("类别");
	}
	
	protected static void testGetType() {
		ArrayList<Type> type = typeDAO.getTagByMID(1);
		for(Type t : type) {
			System.out.println(t.getTypename());
		}
	}
	
	public static void main(String[] args) {
		// testInsert();
		// testGet();
		// testDelete();
		testGetType();
	}
}
