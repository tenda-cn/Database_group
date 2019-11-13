package dao;

import daoImpl.MovieDAOImpl;
import daoImpl.TagDAOImpl;
import daoImpl.TypeDAOImpl;
import daoImpl.UserDAOImpl;
import daoImpl.WorkerDAOImpl;

public class DAOFactory {
    public static UserDAO getUserDAO(){
        return new UserDAOImpl();
    }
    
    public static MovieDAO getMovieDAO() {
    	return new MovieDAOImpl();
    }
   
    public static WorkerDAO getWorkerDAO() {
    	return new WorkerDAOImpl();
    }
    
    public static TagDAO getTagDAO() {
    	return new TagDAOImpl();
    }
    
    public static TypeDAO getTypeDAO() {
    	return new TypeDAOImpl();
    }
}
