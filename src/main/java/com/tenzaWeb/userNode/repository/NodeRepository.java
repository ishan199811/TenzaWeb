package com.tenzaWeb.userNode.repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenzaWeb.userNode.model.entity.Node;

public interface NodeRepository extends JpaRepository<Node , Long>{

	List<Node> findAllByNodeId(String nodeId);
	LinkedList<Node> findAll();
	List<Node> findByPid(long userId);
}
