package dao;

import java.util.ArrayList;

import entity.Theater;


public interface TheaterDAO {
	public boolean insertTheater(Theater theater);
    public boolean updateTheater(Theater theater);
    public boolean deleteTheater(int tID);
    public Theater getTheater(int tID);
    public ArrayList<Theater> getTheaters();
}
