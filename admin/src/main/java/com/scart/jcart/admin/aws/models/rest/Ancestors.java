/**
 * 
 */
package com.scart.jcart.admin.aws.models.rest;

/**
 * @author Prabhakar Jha
 *
 */
public class Ancestors {
	
	BrowseNode browseNode;

	public BrowseNode getBrowseNode() {
		return browseNode;
	}

	public void setBrowseNode(BrowseNode browseNode) {
		this.browseNode = browseNode;
	}

	@Override
	public String toString() {
		return "Ancestors [browseNode=" + browseNode + "]";
	}
	
}
