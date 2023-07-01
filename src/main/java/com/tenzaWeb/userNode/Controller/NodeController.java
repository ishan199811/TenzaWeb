package com.tenzaWeb.userNode.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenzaWeb.security.serviceImpl.SecurityServiceimpl;
import com.tenzaWeb.security.serviceImpl.UserServiceImpl;
import com.tenzaWeb.userNode.model.entity.Node;
import com.tenzaWeb.userNode.service.NodeService;

@RestController
@RequestMapping("nodes")
public class NodeController {
@Autowired
NodeService nodeService;

@Autowired
SecurityServiceimpl sc;

@Autowired
UserServiceImpl us;

	 @GetMapping
	    public List<Node> nodes() {
	        return getSampleNodeList();
	    }
	 @RequestMapping("nodes")
	    private List<Node> getSampleNodeList() {
	        LinkedList<Node> nodes = nodeService.getAllNode();
	        
			/*
			 * String userId=sc.findLoggedInUsername();
			 * 
			 * User user=us.findByUserId(userId); long id=user.getId(); nodes.subList(0,
			 * (int) id).clear();
			 */
	     
			/* nodes.add(new Node("Root", "0", "Root", "")); */
			/*
			 * nodes.add(new Node("1", "","root" )); nodes.add(new Node("2", "1","left1"));
			 * nodes.add(new Node ("3", "1","right1"));
			 * 
			 * nodes.add(new Node("4", "2","left2")); nodes.add(new Node("5",
			 * "2","right2"));
			 * 
			 * nodes.add(new Node("6", "3","left3"));
			 * 
			 * nodes.add(new Node("7", "3","right3")); nodes.add(new Node("8",
			 * "4","left4")); nodes.add(new Node("9", "4","right4")); nodes.add(new
			 * Node("10", "5","left5")); nodes.add(new Node("11", "5","right5"));
			 * nodes.add(new Node("12", "6","left6")); nodes.add(new Node("13",
			 * "6","right6"));
			 */
	        return nodes;
	    }
	 
	 
	 
	 

}
