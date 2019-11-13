package dao;

import daoImpl.UserDAOImpl;

public class DAOFactory {
    public static UserDAO getUserDAO(){
        return new UserDAOImpl() ;
    }
   
}
