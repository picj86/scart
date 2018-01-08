/**
 * 
 */
package com.scart.jcart.admin.aws.models.rest;

/**
 * @author Prabhakar Jha
 *
 */
public class BrowseNodes {
	private String browseNodeId;
	private String name;
	private String isCategoryRoot;

	Children children;
	Ancestors ancestors;

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

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}

	public String getIsCategoryRoot() {
		return isCategoryRoot;
	}

	public void setIsCategoryRoot(String isCategoryRoot) {
		this.isCategoryRoot = isCategoryRoot;
	}
	
	public Ancestors getAncestors() {
		return ancestors;
	}

	public void setAncestors(Ancestors ancestors) {
		this.ancestors = ancestors;
	}
	
	@Override
	public String toString() {
		return "BrowseNodes [browseNodeId=" + browseNodeId + ", name=" + name + ", isCategoryRoot=" + isCategoryRoot
				+ ", children=" + children + ", ancestors=" + ancestors + "]";
	}
}
