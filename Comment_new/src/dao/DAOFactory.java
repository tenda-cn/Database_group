package dao;

import daoImpl.commentDAOImpl;

public class DAOFactory {
    public static commentDAO getCommentDAO(){
        return new commentDAOImpl() ;
    }
   
}
