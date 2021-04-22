package tcu.webtech.superfrogscheduler.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcu.webtech.superfrogscheduler.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findAllByRole(String role);

    Boolean existsByEmail(String email);
}
