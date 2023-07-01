package com.tenzaWeb.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenzaWeb.cart.model.CartMaster;
import com.tenzaWeb.security.model.entity.User;





public interface CartRepositry extends JpaRepository<CartMaster, Long> {

	//List<CartMaster> findAllByEmployee(Employee user);

	String deleteByLoginId(User loginId);

	//ist<CartMaster> findAllByUserId(User userId);

	List<CartMaster> findAllByLoginId(User loginId);

}
