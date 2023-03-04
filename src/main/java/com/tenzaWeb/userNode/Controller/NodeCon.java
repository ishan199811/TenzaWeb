package com.tenzaWeb.userNode.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenzaWeb.user.model.User;
import com.tenzaWeb.user.service.SecurityService;
import com.tenzaWeb.user.service.impl.UserServiceImpl;
import com.tenzaWeb.userNode.model.entity.Node;
import com.tenzaWeb.userNode.service.NodeService;

@Controller
public class NodeCon {
	
	@Autowired
	NodeService nodeService;

	@Autowired
	SecurityService sc;

	@Autowired
	UserServiceImpl us;
	
	
	@RequestMapping("/ch")
	public String showChainPage(Model model) {
		String userId =sc.findLoggedInUsername();
		User user=us.findByUserId(userId);
		long userId1=user.getId();
		String str1 = Long.toString(userId1);
		List<Node> node=nodeService.getNodesByPId(userId1);
		model.addAttribute("node",node);
		return "chainnnn";
		
		
	}
	
	

}
