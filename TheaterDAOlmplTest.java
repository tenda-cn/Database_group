package test;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.TheaterDAO;
import entity.Theater;

public class TheaterDAOlmplTest {
	TheaterDAO theaterDAO=DAOFactory.getTheaterDAO();

    public void testInsertTheater() throws Exception {
    //TODO: Test goes here...
    	boolean b=theaterDAO.insertTheater(new Theater(101,"万达影院","商业路123号"));
        
    }

    /**
    *
    * Method: updateTheater(Theater theater)
    *
    */
    public void testUpdateTheater() throws Exception {
    //TODO: Test goes here...
        boolean b=theaterDAO.updateTheater(new Theater(102,"万达影院","商业路123号"));
     
    }

    /**
    *
    * Method: deleteTheater(String )
    *
    */
    public void testDeleteTheater() throws Exception {
        boolean b=theaterDAO.deleteTheater(102);
        
    //TODO: Test goes here...
    }

    /**
    *
    * Method: getSellTicket(String )
    *
    */
    public void testGetTheater() throws Exception {
    //TODO: Test goes here...
    	Theater theater=theaterDAO.getTheater(102);
        System.out.println("tID:"+theater.gettName());
        System.out.println("tLocation:"+theater.gettLocation());
    }
    /**
    *
    * Method: getTheater()
    *
    */
    public void testGetTheaters() throws Exception {
    //TODO: Test goes here...
        ArrayList<Theater> list=theaterDAO.getTheaters();
        System.out.println(list.size());
        for(Theater theater:list){
            System.out.println(theater.gettID());
        }
    }
}
