package pl.sobocinska.sugarplus.users;

import java.util.List;

public interface UserService {
    List<User> findAllByVisibleTrue();
    User findUserById(Long id);
    void createUser(User user);
    void editUser(User user);
    void deleteVisible(User user);
    User findUserByUserName(String username);
}
