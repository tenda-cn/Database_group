package dao;

import daoImpl.*;

public class DAOFactory {
    public static UserDAO getUserDAO(){
        return new UserDAOImpl() ;
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
    public static commentDAO getCommentDAO(){
        return new commentDAOImpl() ;
    }
    public static TheaterDAO getTheaterDAO(){
        return new TheaterDAOlmpl() ;
   
 }
    public static DiscussionDAO getDiscussionDAO() {
    	return new DiscussionDAOImpl();
    }
    public static PriceDAO getPriceDAO() {
    	return new PriceDaoImpl();
    }
}
