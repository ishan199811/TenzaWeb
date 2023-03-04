package com.tenzaWeb.user.repositotry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenzaWeb.user.model.Reference;
import com.tenzaWeb.user.model.User;

public interface ReferenceRepository extends JpaRepository<Reference , Long> {

	
	
	List<Reference> findByReferenceId(String referenceId);

	List<Reference> findByPosition(String position);
	
	
	
}
