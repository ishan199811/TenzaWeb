package com.tenzaWeb.user.repositotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenzaWeb.user.model.Role;



public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(String string);
}
