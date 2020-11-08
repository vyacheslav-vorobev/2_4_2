package structure.dao;

import structure.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    public User getUser(long series);
}
