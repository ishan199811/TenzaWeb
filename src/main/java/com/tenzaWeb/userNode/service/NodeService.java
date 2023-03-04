package com.tenzaWeb.userNode.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenzaWeb.userNode.model.entity.Node;
import com.tenzaWeb.userNode.repository.NodeRepository;

@Service
public class NodeService {
@Autowired
NodeRepository noderepo;

public LinkedList<Node> getAllNode(){
	
	
	return noderepo.findAll();
	
}

public List<Node> getAlllNode(String id){
	
	List<Node> node= noderepo.findAllByNodeId(id);
List<Node> sublist=node.subList(2, 3);
return sublist;
}
public void saveNode(Node node){
	
	
	 noderepo.save(node);
	
}

public List<Node> getNodesByPId(long userId) {
	
	return noderepo.findByPid(userId);
}



}
