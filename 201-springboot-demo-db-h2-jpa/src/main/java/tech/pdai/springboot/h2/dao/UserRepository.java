package tech.pdai.springboot.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.pdai.springboot.h2.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
