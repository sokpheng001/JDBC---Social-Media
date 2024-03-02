package users;

import users.model.User;

import java.util.List;

public class UserServiceImp implements UserService{
    private final UserRepository userRepository = new UserRepository();
    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public int deleteUserByUuid(String uuid) {
        return userRepository.deleteUserUuid(uuid);
    }
}
