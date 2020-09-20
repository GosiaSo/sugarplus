package pl.sobocinska.sugarplus.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByVisibleTrue();
    User findByUsername(String username);

}
