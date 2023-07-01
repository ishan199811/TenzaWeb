package com.tenzaWeb.userNode.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tenzaWeb.product.model.entity.Brand;


import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
public class Node {
	
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	  private long nodeId; // node id
	
		/*
		 * @ManyToOne(fetch = FetchType.LAZY)
		 * 
		 * @JoinColumn(name = "id", nullable = false)
		 */
	    private long pid; // parent id
	 
	private String text;
	    

	    public Node(long nodeId, long pId, String text) {
	        this.nodeId = nodeId;
	        this.pid = pId;
	        this.text = text;
	       
	    }


		public Node() {
			// TODO Auto-generated constructor stub
		}


		public long getNodeId() {
			return nodeId;
		}


		public void setNodeId(long nodeId) {
			this.nodeId = nodeId;
		}


		public long getPid() {
			return pid;
		}


		public void setPid(long pid) {
			this.pid = pid;
		}


		public String getText() {
			return text;
		}


		public void setText(String text) {
			this.text = text;
		}
}
