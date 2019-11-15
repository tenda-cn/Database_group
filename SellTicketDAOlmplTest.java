package test;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.SellTicketDAO;
import entity.SellTicket;



public class SellTicketDAOlmplTest {
	SellTicketDAO sellTicketDAO=DAOFactory.getSellTicketDAO();

    public void testInsertSellTicket() throws Exception {
    //TODO: Test goes here...
    	boolean b=sellTicketDAO.insertSellTicket(new SellTicket(101,0121,50));
        
    }

    /**
    *
    * Method: updateSellTicket(SellTicket sellTicket)
    *
    */
    public void testUpdateSellTicket() throws Exception {
    //TODO: Test goes here...
        boolean b=sellTicketDAO.updateSellTicket(new SellTicket(101,0121,60));
     
    }

    /**
    *
    * Method: deleteSellTicket(String )
    *
    */
    public void testDeleteSellTicket() throws Exception {
        boolean b=sellTicketDAO.deleteSellTicket(0121);
        
    //TODO: Test goes here...
    }

    /**
    *
    * Method: getSellTicket(String )
    *
    */
    public void testGetSellTicket() throws Exception {
    //TODO: Test goes here...
    	SellTicket sellTicket=sellTicketDAO.getSellTicket(0121);
        System.out.println("tid:"+sellTicket.getTid());
        System.out.println("duration:"+sellTicket.getTicketPrice());
    }
    /**
    *
    * Method: getSellTicket()
    *
    */
    public void testGetSellTickets() throws Exception {
    //TODO: Test goes here...
        ArrayList<SellTicket> list=sellTicketDAO.getSellTickets();
        System.out.println(list.size());
        for(SellTicket sellTicket:list){
            System.out.println(sellTicket.getTid());
        }
    }
}
