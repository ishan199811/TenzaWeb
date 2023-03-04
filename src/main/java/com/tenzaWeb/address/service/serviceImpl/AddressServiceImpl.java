package com.tenzaWeb.address.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenzaWeb.address.model.entity.Address;
import com.tenzaWeb.address.repository.AddressRepository;
import com.tenzaWeb.address.service.AdderessService;
import com.tenzaWeb.user.model.User;
import com.tenzaWeb.user.service.SecurityService;
import com.tenzaWeb.user.service.UserService;

@Service
public class AddressServiceImpl implements AdderessService{

	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	SecurityService securityService;
	
	@Autowired 
	UserService userService;
	
	@Override
	public List<Address> getAllAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Address address) {
		
		
		String userId = securityService.findLoggedInUsername();
		User user=userService.findByUserId(userId);
		address.setUserId(user);
		
		addressRepo.save(address);
	}

	@Override
	public List<Address> findAddressByUserId(User userId) {
		// TODO Auto-generated method stub
		return addressRepo.findAddressByUserId(userId);
	}

}
