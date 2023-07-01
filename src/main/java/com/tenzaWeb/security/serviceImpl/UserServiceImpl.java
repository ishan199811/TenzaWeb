package com.tenzaWeb.security.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.tenzaWeb.security.model.dto.UserDto;
import com.tenzaWeb.security.model.entity.Refrence;
import com.tenzaWeb.security.model.entity.Role;
import com.tenzaWeb.security.model.entity.User;
import com.tenzaWeb.security.repo.RefrenceRepo;
import com.tenzaWeb.security.repo.RoleRepo;
import com.tenzaWeb.security.repo.UserRepository;
import com.tenzaWeb.security.service.UserService;
import com.tenzaWeb.security.util.AuthUtil;




@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	RefrenceRepo refrenceRepo;
	
	
	//UserServiceImpl us=new UserServiceImpl();
	
	
	@Override
	public String saveData(UserDto userDto ,BindingResult bindingResult ,Model model) throws Exception {
	
		if (bindingResult.hasErrors()) {
			//("Error" + bindingResult);

			return "Register2";
		}
		 String refId=userDto.getSponserId();
			

//		  if(us.existsByMobileNumber(userDto.getMobileNo())) {
//		  model.addAttribute("m","Mobile Number already registerd" );
//		  
//		  return "Register"; 
//		  }
//		 	
		 if(userRepo.existsBySponserId(refId)) { 
        String loginId=AuthUtil.generateUserId();
		//("......................................hello");
		
		userDto.setLoginId(loginId);
		 model.addAttribute("w", "refrence id does not match"); 
		  return "Register"; 
		  }

		
		
		User user=new User();
	Refrence reff= new Refrence();
	
	User user11=userRepo.findByLoginId(userDto.getSponserId());
	
	
		user.setLoginId(userDto.getLoginId());
		user.setFullname(userDto.getFullName());
		user.setMobileNo(userDto.getMobileNo());
		user.setEmail(userDto.getEmail());
	
		//user.setConfirmPassword(userDto.getConfirmPassword());
		 //user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		 
		Role role = roleRepo.findByRoleName("USER");
		Set roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		
		

		User user1= userRepo.save(user);
		
		reff.setPosition(userDto.getPosition());
		reff.setSponserId(userDto.getSponserId());
		reff.setUserId(user);  
		refrenceRepo.save(reff); 
		
		//messageService.sendEmail(user1.getEmail(), "email", prepareOtpMessage(user));
				
		String email= user1.getEmail();
		return email;
	}
	
	
	




	@Override
	public String saveDataa(UserDto userDto, BindingResult bindingResult ,Model model) {
		User user=new User();
		
//		 if (us.existsByemail(userDto.getEmail())) {
//			  model.addAttribute("e","email already registerd" );
//			 
//			  return "regg"; }
//			 
			  String refId=userDto.getSponserId();
			  				

//			  if(us.existsByMobileNumber(userDto.getMobileNo())) {
//			  model.addAttribute("m","Mobile Number already registerd" );
//			  
//			  return "regg"; 
//			  }
//			 	
		 
	         String userId=AuthUtil.generateUserId();
			//("......................................hello");
			
			userDto.setLoginId(userId);
			
		
		
		user.setLoginId(userDto.getLoginId());
		user.setFullname(userDto.getFullName());
		user.setMobileNo(userDto.getMobileNo());
		user.setEmail(userDto.getEmail());
	
	//	user.setConfirmPassword(userDto.getConfirmPassword());
	//	 user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		 
		Role role = roleRepo.findByRoleName("USER");
		Set roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		
		

		User user1= userRepo.save(user);
		
		//messageService.sendEmail(user1.getEmail(), "email", prepareOtpMessage(user));
				
		String email= user1.getEmail();
		return email;
		
	}


	@Override
	public User findByUserId(String loginId) {
		// TODO Auto-generated method stub
		return userRepo.findByLoginId(loginId);
	}

	@Override
	public boolean existsByMobileNumber(String mobileNo) {
		return userRepo.existsByMobileNo(mobileNo);
	}
	
	@Override
	public boolean existsByemail(String email) {
		// TODO Auto-generated method stub
		return userRepo.existsByEmail(email);
	}







	@Override
	public User findByLoginId(String loginId) {
		// TODO Auto-generated method stub
		return userRepo.findByLoginId(loginId);
	}







	@Override
	public List<User> listAll() {
		// TODO Auto-generated method stub
		return null;
	}







	@Override
	public void saveRole(Role role) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}







	@Override
	public User get(String userId) {
		// TODO Auto-generated method stub
		return null;
	}







	@Override
	public List<Role> listRoles() {
		// TODO Auto-generated method stub
		return null;
	}







	

}
