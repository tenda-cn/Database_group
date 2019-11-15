package test;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	// 根据名称获取mid
	protected static void testCasePart1(String movieName) {
		MovieDAOImpl movieDAO = (MovieDAOImpl) DAOFactory.getMovieDAO();
		ArrayList<Integer> mids = movieDAO.getMIDByName(movieName);
		Iterator<Integer> iter = mids.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	// 根据名称显示所有详细信息
	protected static void testCasePart2(int mid) {
		MovieDAOImpl movieDAO = (MovieDAOImpl) DAOFactory.getMovieDAO();
		Movie movie = movieDAO.get(mid);
		WorkerDAOImpl workerDAO = (WorkerDAOImpl) DAOFactory.getWorkerDAO();
		TagDAOImpl tagDAO = (TagDAOImpl) DAOFactory.getTagDAO();
		TypeDAOImpl typeDAO = (TypeDAOImpl) DAOFactory.getTypeDAO();
		ArrayList<Worker> directors = workerDAO.getDirectorByMID(1);
		ArrayList<Worker> author = workerDAO.getAuthorByMID(1);
		ArrayList<Worker> actor = workerDAO.getActorByMID(1);
		ArrayList<Tag> tags = tagDAO.getTagByMID(mid);
		ArrayList<Type> type = typeDAO.getTypeByMID(mid);
		System.out.println("电影ID：" + movie.getmID());
		System.out.print("导演：");
		Iterator<Worker> iter = directors.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next().getName() + " ");
		}
		System.out.print("\n编剧：");
		iter = author.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next().getName() + " ");
		}
		System.out.print("\n演员：");
		iter = actor.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next().getName() + " ");
		}
		System.out.println("\n语言：" + movie.getMovieLanguage());
		System.out.println("时长：" + movie.getDuration());
		System.out.println("地区：" + movie.getArea());
		System.out.println("上映日期：" + movie.getReleaseTime());
		System.out.println("又名：" + movie.getArea());
		System.out.print("标签：");
		Iterator<Tag> ti = tags.iterator();
		while(ti.hasNext()) {
			System.out.print(ti.next().getTag() + " ");
		}
		System.out.print("\n类别：");
		Iterator<Type> tpi = type.iterator();
		while(tpi.hasNext()) {
			System.out.print(tpi.next().getTypename() + " ");
		}
		System.out.println("\n票价：" + movie.getPrice());
		System.out.println("简介：" + movie.getContent());
	}

	public static void main(String[] args) {
		MovieDAOImpl movieDAO = (MovieDAOImpl) DAOFactory.getMovieDAO();
		Movie movie = movieDAO.get(1);
		System.out.println(movie.getContent());
		//testInsert();
		//testDelete();
		
		//movie.setContent("content");
		//movie.setPrice(39.99);
		//movieDAO.update(movie);
		
		testCasePart1("m1");
		testCasePart2(1);
	}

}
