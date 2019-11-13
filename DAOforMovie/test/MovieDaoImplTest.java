package test;

import dao.DAOFactory;
import daoImpl.*;
import entity.*;

public class MovieDaoImplTest {

	protected static void testInsert() {
		MovieDAOImpl movieDAO = (MovieDAOImpl) DAOFactory.getMovieDAO();
		Movie movie = new Movie();
		movie.setmID(3);
		movie.setMname("3name");
		movie.setMovieLanguage("cn");
		movie.setDuration("100.59");
		movie.setArea("AS");
		movie.setReleaseTime("2020-01-01");
		movie.setOtherName("zzz/zz");
		movie.setContent("content");
		movie.setPrice(40);
		movieDAO.insert(movie);
	}
	
	protected static void testDelete() {
		MovieDAOImpl movieDAO = (MovieDAOImpl) DAOFactory.getMovieDAO();
		movieDAO.delete(3);
	}

	public static void main(String[] args) {
		MovieDAOImpl movieDAO = (MovieDAOImpl) DAOFactory.getMovieDAO();
		Movie movie = movieDAO.get(1);
		System.out.println(movie.getContent());
		//testInsert();
		//testDelete();
		movie.setContent("content");
		movie.setPrice(39.99);
		movieDAO.update(movie);
	}

}
