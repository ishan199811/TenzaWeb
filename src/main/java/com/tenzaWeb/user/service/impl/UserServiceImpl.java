package com.tenzaWeb.user.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.tenzaWeb.user.model.Reference;
import com.tenzaWeb.user.model.Role;
import com.tenzaWeb.user.model.User;
import com.tenzaWeb.user.model.request.OTPDto;
import com.tenzaWeb.user.model.request.UserDTO;
import com.tenzaWeb.user.model.request.util.AuthUtil;
import com.tenzaWeb.user.model.request.util.CacheManager;
import com.tenzaWeb.user.repositotry.ReferenceRepository;
import com.tenzaWeb.user.repositotry.RoleRepository;
import com.tenzaWeb.user.repositotry.UserRepository;
import com.tenzaWeb.user.service.MessageService;
import com.tenzaWeb.user.service.SecurityService;
import com.tenzaWeb.user.service.UserService;
import com.tenzaWeb.userNode.model.entity.Node;
import com.tenzaWeb.userNode.service.NodeService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

	
	@Autowired
	ReferenceRepository ref;
	

	@Autowired
	UserRepository userRepo;
	
	@Autowired 
	NodeService node;
	
	@Autowired
	RoleRepository rolerepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	SecurityService sc;
	

	@Override
	public String saveData(UserDTO userDto) throws Exception {
	
		User user=new User();
	Reference reff= new Reference();
	
	User user11=userRepo.findByUserId(userDto.getRefenceId());
	
	
		user.setUserId(userDto.getUserId());
		user.setFullName(userDto.getFullName());
		user.setMobileNumber(userDto.getMobileNumber());
		user.setEmail(userDto.getEmail());
	
		user.setConfirmPassword(userDto.getConfirmPassword());
		 user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		 
		Role role = rolerepo.findByName("USER");
		Set roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		
		

		User user1= userRepo.save(user);
		
		reff.setPosition(userDto.getPosition());
		reff.setReferenceId(userDto.getRefenceId());
		reff.setUserId(user);  
		 ref.save(reff); 
		
		messageService.sendEmail(user1.getEmail(), "email", prepareOtpMessage(user));
				
		String email= user1.getEmail();
		return email;
	}
	

	@Override
	public String saveDataa(UserDTO userDto) throws Exception {
	
		User user=new User();
	
	
	
	
		user.setUserId(userDto.getUserId());
		user.setFullName(userDto.getFullName());
		user.setMobileNumber(userDto.getMobileNumber());
		user.setEmail(userDto.getEmail());
	
		user.setConfirmPassword(userDto.getConfirmPassword());
		 user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		 
		Role role = rolerepo.findByName("USER");
		Set roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		
		

		User user1= userRepo.save(user);
		
		messageService.sendEmail(user1.getEmail(), "email", prepareOtpMessage(user));
				
		String email= user1.getEmail();
		return email;
	}

	
	
	@Override
	public void saveNode() {
		
		Node nod=new Node();
		
		 String userId=sc.findLoggedInUsername();
		 User user2=userRepo.findByUserId(userId);
		long u=user2.getId();
		long ui=u/2;
		long ue=u%2;
		if( ue == 0) {
		nod.setText("Left");
		}else {	
			nod.setText("Right");
		}
			User uq=userRepo.getById(ui);
			nod.setPid(uq.getId());
			
		node.saveNode(nod);
		
	}
	
	@Override
	public String prepareUserIdMessage() {
		String userId=sc.findLoggedInUsername();
		User user=userRepo.findByUserId(userId);
		StringBuilder sb = new StringBuilder();
		sb.append("Dear " + user.getFullName() + "\n");
		sb.append("This your userId :" + userId);
		sb.append("this is your password :" +user.getConfirmPassword());
		
		
		Map m = new HashMap();
		m.put("otp", userId);
		m.put("time", new Date());
		CacheManager.addOTP(m, user.getEmail());
		return sb.toString();
	}	
	
	private String prepareOtpMessage(User users) {
		String otp = AuthUtil.generate4DigitNumber();
		//log.info("otp................" + otp);
		StringBuilder sb = new StringBuilder();
		sb.append("Dear " + users.getFullName() + "\n");
		sb.append("Please verify your otp " + otp);
		Map m = new HashMap();
		m.put("otp", otp);
		m.put("time", new Date());
		CacheManager.addOTP(m, users.getEmail());
		return sb.toString();
	}
	
	



	@Override
	public User findByUserId(String userId) {
		
		return userRepo.findByUserId(userId);
	}
	@Override
	public String resendotp(String email) {
		
		User user=userRepo.findByEmail(email);
	//	log.info("        resend otp"+user);
		if(user==null)
		{
			return null;
		}
		messageService.sendEmail(email, "email", prepareOtpMessage(user));
		
		return null;
	}
	@Override
	public boolean existsByemail(String email) {
		
		return userRepo.existsByemail(email);
	}
	@Override
	public User findByemail(String email) {
		
		return userRepo.findByEmail(email);
	}
	@Override
	public void resetpassword(OTPDto dto) {
		//log.info("             reset service");
		
		User user=userRepo.findByEmail(dto.getEmail());
	//	log.info("             reset service"+user);
		
		user.setConfirmPassword(dto.getConfirmPasword());
		 user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		 userRepo.save(user);
		
		
	}
	@Override
	public User get(String userId) {
		
		return userRepo.findUserByUserId(userId).get();
	}
	@Override
	public List<Role> listRoles() {
		
		 return rolerepo.findAll();
	}
	@Override
	public List<User> listAll() {
		
		 return userRepo.findAll();
	}
@Override
	public void saveRole(Role role) {
	Role roles=new Role();
	role.setName("USER");
	roles.setName("ADMIN");
	rolerepo.save(role);
	rolerepo.save(roles);
	
	}
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}
	@Override
	public boolean existsByMobileNumber(long mobileNumber) {
		
		return userRepo.existsByMobileNumber(mobileNumber);
	}

	@Override
	public List<Reference> getUserByReferenceId(String refrenceId) {
        String userId=sc.findLoggedInUsername();
        List<Reference> reff= ref.findByReferenceId(userId);
		/*for(Reference refff:reff) {
			String position=refff.getPosition();
			if(position=="left") {
				return reff;
			}*/

		
		
		return ref.findByReferenceId(userId);
      
	
	
		
	}
	
public boolean existsByUserId(String refrenceId) {
		
		return userRepo.existsByUserId(refrenceId);
	}
		
}
