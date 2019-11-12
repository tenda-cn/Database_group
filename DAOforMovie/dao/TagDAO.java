package dao;

import java.util.ArrayList;
import entity.Tag;

public interface TagDAO {
	public boolean insert(Tag tag);
	// public boolean update(Tag tag); // 只有一个属性怎么update
	public boolean delete(String tag);
	public Tag get(String tag);
	public ArrayList<Tag> getTagByMID(int mid);
}
