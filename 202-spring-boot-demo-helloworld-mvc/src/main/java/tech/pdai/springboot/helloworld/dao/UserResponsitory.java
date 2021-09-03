package tech.pdai.springboot.helloworld.dao;

import com.pdai.swagger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponsitory extends JpaRepository<User, Integer> {

}
