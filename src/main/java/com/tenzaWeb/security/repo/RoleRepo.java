package com.tenzaWeb.security.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenzaWeb.security.model.entity.Role;
@Repository
public interface RoleRepo extends JpaRepository<Long , Role> {

	Role findByName(String string);

}
