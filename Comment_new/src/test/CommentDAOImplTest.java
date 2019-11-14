package test; 

import dao.DAOFactory;


import dao.commentDAO;
import entity.comment;

import java.util.ArrayList;

public class CommentDAOImplTest {

    commentDAO commDAO=DAOFactory.getCommentDAO();

    public void testInsertComment() throws Exception {
    //TODO: Test goes here...
        boolean b=commDAO.insertComment(new comment(1001,"2019-11-12","非常有价值的一部电影","手机",200));
        
    }

    /**
    *
    * Method: updateComment(comment comm)
    *
    */
    public void testUpdateComment() throws Exception {
    //TODO: Test goes here...
        boolean b=commDAO.updateComment(new comment(1002,"2019-10-2","有意义的电影","电脑",301));
     
    }

    /**
    *
    * Method: deleteComment(int cid)
    *
    */
    public void testDeleteComment() throws Exception {
        boolean b=commDAO.deleteComment(1002);
        
    //TODO: Test goes here...
    }

    /**
    *
    * Method: getComment(int cid)
    *
    */
    public void testGetComment() throws Exception {
    //TODO: Test goes here...
        comment comm=commDAO.getComment(1002);
        System.out.println("cid:"+comm.getCid());
        System.out.println("c_time:"+comm.getC_time());
        System.out.println("c_content:"+comm.getC_content());
        System.out.println("c_facility:"+comm.getC_facility());
        System.out.println("useful_amount:"+comm.getUseful());
    }

    /**
    *
    * Method: getComment()
    *
    */
    public void testGetComment2() throws Exception {
    //TODO: Test goes here...
        ArrayList<comment> list=commDAO.getComment();
        System.out.println(list.size());
        for(comment comm:list){
            System.out.println(comm.getC_time());
        }
    }

} 
