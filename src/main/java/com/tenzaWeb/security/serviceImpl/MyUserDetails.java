package com.tenzaWeb.security.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.tenzaWeb.security.model.entity.Role;
import com.tenzaWeb.security.model.entity.User;




public class MyUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	
	private User user;
    
    public MyUserDetails(User user) {
        this.user = user;
        
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
         
        return authorities;
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
    
    public String getEmail() {
    	return user.getEmail();
    }
 public String getFullName(){
	 return user.getFullname();
 }
    @Override
    public String getUsername() {
        return user.getLoginId();
    }
 
public String getUserId() {
	return user.getLoginId();
	
}
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
}



