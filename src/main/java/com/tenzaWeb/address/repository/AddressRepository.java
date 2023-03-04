package com.tenzaWeb.address.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenzaWeb.address.model.entity.Address;
import com.tenzaWeb.user.model.User;

public interface AddressRepository extends JpaRepository<Address , Long> {

	List<Address> findAddressByUserId(User userId);

}
