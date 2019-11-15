package entity;


public class SellTicket {
	public int mID;
	public int tid;
	public float ticketPrice;
	public SellTicket(int mID,int tid,float ticketPrice)
	{
		this.mID=mID;
		this.tid=tid;
		this.ticketPrice=ticketPrice;
	}
	public SellTicket() {}
	public void setmID(int mID) {
		this.mID = mID;
	}
	public int getmID() {
		return mID;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getTid() {
		return tid;
	}
	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public float getTicketPrice() {
		return ticketPrice;
	}
}

