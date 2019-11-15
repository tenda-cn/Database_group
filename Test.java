import daoImpl.UserDAOImpl;
import daoImpl.commentDAOImpl;
import entity.User;
import test.CommentDAOImplTest;
import test.MovieDaoImplTest;
import test.TagDAOImplTest;
import test.TheaterDAOlmplTest;
import test.UserDAOImplTest;

public class Test {
	public static void main(String[] args) throws Exception {
		// User测试
		//UserDAOImplTest userDAOImplTest = new UserDAOImplTest();
		//userDAOImplTest.testInsertUser();
		// userDAOImplTest.testDeleteUser();
		/*UserDAOImpl userDAOImpl=new UserDAOImpl();
		userDAOImpl.insertUser(new User(3,"张三","","123","","","男"));
		userDAOImpl.insertUser(new User(4,"李小巫","","123","","","男"));
		userDAOImpl.insertUser(new User(5,"赵小六","","123","","","女"));
		userDAOImpl.insertUser(new User(6,"王小七","","123","","","男"));
		userDAOImplTest.testGetUsers();;*/

		// Theater 测试
		  //TheaterDAOlmplTest theaterDAOlmplTest=new TheaterDAOlmplTest();
		  //theaterDAOlmplTest.testInsertTheater();
		 // theaterDAOlmplTest.testUpdateTheater();
		 // theaterDAOlmplTest.testGetTheater();
		//Movie测试  
		 //MovieDaoImplTest movieDaoImplTest=new MovieDaoImplTest();
		 // movieDaoImplTest.testInsert(); 
		 // movieDaoImplTest.testDelete();
		 
		/*
		 * TagDAOImplTest tagDAOImplTest=new TagDAOImplTest();
		 * tagDAOImplTest.testInsert(); tagDAOImplTest.testDelete();
		 */

		
		  CommentDAOImplTest comment=new CommentDAOImplTest();
		 // comment.testInsertComment();
		//  comment.testUpdateComment();
		//  comment.testGetComment();
		 comment.testGetCommentByMID();
		 
		 

	}
}
