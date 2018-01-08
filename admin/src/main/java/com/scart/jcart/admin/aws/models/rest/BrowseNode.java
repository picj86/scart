/**
 * 
 */
package com.scart.jcart.admin.aws.models.rest;

/**
 * @author Prabhakar Jha
 *
 */
public class BrowseNode {
	
	private String browseNodeId;
	private String name;
	
	public String getBrowseNodeId() {
		return browseNodeId;
	}
	public void setBrowseNodeId(String browseNodeId) {
		this.browseNodeId = browseNodeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BrowseNode [browseNodeId=" + browseNodeId + ", name=" + name + "]";
	}
}
