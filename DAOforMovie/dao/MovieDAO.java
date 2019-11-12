package dao;
import java.util.ArrayList;
import entity.Movie;

public interface MovieDAO {
	public boolean insert(Movie movie);
	public boolean update(Movie movie);
	public boolean delete(int mID);
	public Movie get(int mID);
	public ArrayList<Movie> getALL();
}
