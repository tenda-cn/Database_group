package dao;

import java.util.ArrayList;
import entity.SellTicket;

public interface SellTicketDAO {
	 public boolean insertSellTicket(SellTicket sellTicket);
	    public boolean updateSellTicket(SellTicket sellTicket);
	    public boolean deleteSellTicket(int tid);
	    public SellTicket getSellTicket(int tid);
	    public ArrayList<SellTicket> getSellTickets();
}
