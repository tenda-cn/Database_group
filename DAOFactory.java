package dao;

import daolpmp.TheaterDAOlmpl;

public class DAOFactory {
	public static TheaterDAO getTheaterDAO(){
        return new TheaterDAOlmpl() ;
}
}
