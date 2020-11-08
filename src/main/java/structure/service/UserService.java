package structure.service;

import structure.model.User;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUser(long series);
}
