package com.tenzaWeb.user.repositotry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tenzaWeb.user.model.User;



public interface UserRepository extends JpaRepository<User, Long> {

	
	 @Query("SELECT u FROM User u WHERE u.userId = :userId")
	User findByUserId(@Param("userId")String userId);

	User findByEmail(String email);

	boolean existsByemail(String email);
	
	boolean existsByMobileNumber(long mobileNumber);
	
	boolean existsByUserId(String userId);

	Optional<User> findUserByUserId(String userId);

	
}
