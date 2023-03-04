package com.tenzaWeb.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenzaWeb.cart.model.CartMaster;
import com.tenzaWeb.user.model.User;





public interface CartRepositry extends JpaRepository<CartMaster, Long> {

	//List<CartMaster> findAllByEmployee(Employee user);

	String deleteByUserId(User userId);

	List<CartMaster> findAllByUserId(User userId);

}
