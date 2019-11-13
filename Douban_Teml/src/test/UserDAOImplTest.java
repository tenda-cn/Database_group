package test; 

import dao.DAOFactory;
import dao.UserDAO;
import entity.User;
import java.util.ArrayList;

public class UserDAOImplTest {

    UserDAO userDAO=DAOFactory.getUserDAO();

    public void testInsertUser() throws Exception {
    //TODO: Test goes here...
        boolean b=userDAO.insertUser(new User("U3","用户3","188423612@qq.com","123456","13358966541","武汉","男"));
        
    }

    /**
    *
    * Method: updateUser(User user)
    *
    */
    public void testUpdateUser() throws Exception {
    //TODO: Test goes here...
        boolean b=userDAO.updateUser((new User("U3","用户3","188423612@qq.com","123456","13358966541","南京","男")));
     
    }

    /**
    *
    * Method: deleteUser(String uid)
    *
    */
    public void testDeleteUser() throws Exception {
        boolean b=userDAO.deleteUser("U3");
        
    //TODO: Test goes here...
    }

    /**
    *
    * Method: getUser(String uid)
    *
    */
    public void testGetUser() throws Exception {
    //TODO: Test goes here...
        User user=userDAO.getUser("U1");
        System.out.println("name:"+user.getUsername());
        System.out.println("city:"+user.getAddr());
        System.out.println("tel:"+user.getTel());
        System.out.println("email:"+user.getEmail());
        System.out.println("gender:"+user.getGender());
    }

    /**
    *
    * Method: getUsers()
    *
    */
    public void testGetUsers() throws Exception {
    //TODO: Test goes here...
        ArrayList<User> list=userDAO.getUsers();
        System.out.println(list.size());
        for(User user:list){
            System.out.println(user.getUsername());
        }
    }

} 
