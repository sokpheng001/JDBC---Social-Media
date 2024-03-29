package users;

import users.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    int deleteUserByUuid(String uuid);
    List<User> searchUserByName(String name);
}
