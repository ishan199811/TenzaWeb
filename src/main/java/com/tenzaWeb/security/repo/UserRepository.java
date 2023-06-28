package com.tenzaWeb.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenzaWeb.security.model.entity.User;
@Repository
public interface UserRepository extends JpaRepository<Long,User>
{

	User findByLoginId(String sponserId);

	User save(User user);

	boolean existsById(String sponserId);

	boolean existsByMobileNo(String mobileNo);

	boolean existsByEmail(String email);

}
