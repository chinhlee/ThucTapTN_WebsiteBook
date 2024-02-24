package hunre.chinh.webbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hunre.chinh.webbook.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
