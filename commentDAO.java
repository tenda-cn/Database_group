package dao;

import entity.comment;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by FuCongchong on 2019/11/12  22:34
 */
public interface commentDAO {
    public boolean insertComment(comment comm);
    public boolean insertBe_Comment(comment comm,int mID);
    public boolean updateComment(comment comm);
    public boolean deleteComment(int cid);
    public comment getComment(int cid);
    public ArrayList<comment> getComment();
    public ArrayList<comment> getByMID(ArrayList<Integer> comms,int mid);//通过具体的cid数组把comment的各项信息找到
    public ArrayList<Integer> getComments(int mid);//通过电影ID在评价-电影联系表中，获取某一个电影对应的所有评论
    public ArrayList<comment> getCommentByMID(int mid);//传入一个mid，直接获取与之对应的所有评价的各项信息
}
