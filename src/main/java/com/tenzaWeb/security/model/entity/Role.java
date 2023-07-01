package com.tenzaWeb.security.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	   Long roleId;
	
	String roleName;
	
	
	@ManyToMany(mappedBy="roles")
	Set<User> user;


	public long getRoleId() {
		return roleId;
	}


	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Set<User> getUser() {
		return user;
	}


	public void setUser(Set<User> user) {
		this.user = user;
	}

}
