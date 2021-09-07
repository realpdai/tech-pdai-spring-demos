package tech.pdai.springboot2unit5.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.pdai.springboot2unit5.entity.User;

/**
 * user dao.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
