package com.tenzaWeb.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenzaWeb.security.model.entity.Refrence;
@Repository
public interface RefrenceRepo extends JpaRepository<Refrence,Long>{

	public Refrence save(Refrence reff);

}
