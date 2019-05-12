package sii.matyliano.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sii.matyliano.spring.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByName(String username);

}
