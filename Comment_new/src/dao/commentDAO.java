package dao;

import entity.comment;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by FuCongchong on 2019/11/12  22:34
 */
public interface commentDAO {
    public boolean insertComment(comment comm);
    public boolean updateComment(comment comm);
    public boolean deleteComment(int cid);
    public comment getComment(int cid);
    public ArrayList<comment> getComment();
}
