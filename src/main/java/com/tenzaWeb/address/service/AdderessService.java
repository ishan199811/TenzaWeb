package com.tenzaWeb.address.service;

import java.util.List;

import com.tenzaWeb.address.model.entity.Address;
import com.tenzaWeb.user.model.User;

public interface AdderessService {
	
	List<Address> getAllAddress();

	void save(Address address);

	List<Address> findAddressByUserId(User user1);


}
