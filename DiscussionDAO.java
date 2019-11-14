package dao;
import java.util.ArrayList;
import entity.Discussion;
public interface DiscussionDAO {
    public boolean insertDiscussion(Discussion discussion);
    public boolean updateDiscussion(Discussion discussion);
    public boolean deleteDiscussion(int did);
    public Discussion getDiscussion(int did);
    public ArrayList<Discussion> getDiscussions();
}
