package dao;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDAO {
    public boolean insertUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(String uid);
    public User getUser(String uid);
    public ArrayList<User> getUsers();
}
