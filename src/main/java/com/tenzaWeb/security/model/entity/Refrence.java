package com.tenzaWeb.security.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Refrence {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
 private String sponserId;
 
 @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User userId;
 
 private String position;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getSponserId() {
	return sponserId;
}

public void setSponserId(String sponserId) {
	this.sponserId = sponserId;
}

public User getUserId() {
	return userId;
}

public void setUserId(User userId) {
	this.userId = userId;
}

public String getPosition() {
	return position;
}

public void setPosition(String position) {
	this.position = position;
}

}
