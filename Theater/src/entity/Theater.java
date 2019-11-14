package entity;

public class Theater {
	public int tID;
	public String tName;
	public String tLocation;
	public Theater(int tID,String tName,String tLocation)
	{
		this.tID=tID;
		this.tName=tName;
		this.tLocation=tLocation;
	}
	public Theater() {}
	public void settID(int tID) {
		this.tID = tID;
	}
	public int gettID() {
		return tID;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettName() {
		return tName;
	}
	public void settLocation(String tLocation) {
		this.tLocation = tLocation;
	}
	public String gettLocation() {
		return tLocation;
	}
}
