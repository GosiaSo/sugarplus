package pl.sobocinska.sugarplus.users;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JpaUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public JpaUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findAllByVisibleTrue() {
        return userRepository.findAllByVisibleTrue();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void editUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteVisible(User user) {
        user.setVisible(false);
        userRepository.save(user);
    }
}
