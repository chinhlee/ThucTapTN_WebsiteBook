package hunre.chinh.webbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hunre.chinh.webbook.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

}
