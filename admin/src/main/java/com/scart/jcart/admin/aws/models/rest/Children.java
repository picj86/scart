package com.scart.jcart.admin.aws.models.rest;

import java.util.ArrayList;
import java.util.List;

public class Children {
	
	private List<BrowseNode> browseNode = new ArrayList<BrowseNode>();

	public List<BrowseNode> getBrowseNode() {
		return browseNode;
	}

	public void setBrowseNode(List<BrowseNode> browseNode) {
		this.browseNode = browseNode;
	}

	@Override
	public String toString() {
		return "Children [browseNode=" + browseNode + "]";
	}
}
